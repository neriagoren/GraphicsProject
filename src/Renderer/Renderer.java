package Renderer;

import Elements.Light;
import Geometries.GeoPoint;
import Geometries.Geometry;
import Geometries.Plane;
import Primitives.Point3D;
import Primitives.Ray;
import Scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    private Scene _scene;
    private ImageWriter _imageWriter;


    public Renderer(ImageWriter imageWriter, Scene scene) {
        this._scene = scene;
        this._imageWriter = imageWriter;
    }

    public void setScene(Scene scene) {
        this._scene = scene;
    }

    public Scene getScene() {
        return this._scene;
    }

    public void setImageWriter(ImageWriter imageWriter) {
        this._imageWriter = imageWriter;
    }

    public ImageWriter getImageWriter() {
        return this._imageWriter;
    }

    public void renderImage() {
        for (int i = 0; i < this._imageWriter.getNy(); i++) {
            for (int j = 0; j < this._imageWriter.getNx(); j++) {
                Ray ray = this._scene.getCamera().
                        constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
                List<GeoPoint> intersectionPoints = getSceneRayIntersections(ray);

                if (intersectionPoints.isEmpty()) {
                    _imageWriter.writePixel(j, i, _scene.getBackground());
                }
                else {
                    GeoPoint closestPoint = getClosestPoint(intersectionPoints);

                    if (closestPoint.getGeometry() instanceof Plane) {
                        double x = closestPoint.getPoint().getX().getCoordinate();
                        double z = closestPoint.getPoint().getZ().getCoordinate();
                        if (((int) (z / 500) + (int) (x / 500)) % 2 == 0) {
                            closestPoint.getGeometry().setEmission(Color.BLACK);
                        }
                        else {
                            closestPoint.getGeometry().setEmission(Color.WHITE);
                        }
                    }

                    _imageWriter.writePixel(j, i, calcColor(closestPoint));
                }
            }
        }
        _imageWriter.writeToImage();
    }

    private List<GeoPoint> getSceneRayIntersections(Ray ray) {
        List<GeoPoint> intersectionPoints = new ArrayList<>();

        for (Geometry geometry : this._scene.getGeometries()) {
            // findIntersections might return NULL !!!
            List<GeoPoint> geometryIntersectionPoints = geometry.findIntersections(ray);
            if (geometryIntersectionPoints != null) {
                intersectionPoints.addAll(geometryIntersectionPoints);
            }
        }
        // intersectionPoints might be empty! (not NULL)
        return intersectionPoints;
    }

    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = this._scene.getCamera().getP0();
        GeoPoint minDistancePoint = null;

        for (GeoPoint gPoint : intersectionPoints) {
            if (P0.distance(gPoint.getPoint()) < distance) {
                minDistancePoint = gPoint;
                distance = P0.distance(gPoint.getPoint());
            }
        }
        return minDistancePoint;
    }

    private Color calcDiffusiveComp(double kD, Ray.Vector normal, Ray.Vector l, Color iL) {
        int r = (int) (kD * normal.dotProduct(l) * iL.getRed());
        int g = (int) (kD *  normal.dotProduct(l) * iL.getGreen());
        int b = (int) (kD *  normal.dotProduct(l) * iL.getBlue());

        r = Math.min(r, 255);
        r = Math.max(0, r);
        g = Math.min(g, 255);
        g = Math.max(0, g);
        b = Math.min(b, 255);
        b = Math.max(0, b);

        return new Color(r, g, b);
    }

    private Color calcSpecularComp(double kS, Ray.Vector v, Ray.Vector normal, Ray.Vector l, int shininess, Color iL) {

        if ( l.dotProduct(normal) == 0) {
            System.out.println("l: " + l + " ,normal: " + normal);
        }
        Ray.Vector R = l.subtract(normal.scale(2 * (l.dotProduct(normal)))).normalize();
        int r = (int) (kS *  Math.pow(v.dotProduct(R), shininess) * iL.getRed());
        int g = (int) (kS * Math.pow(v.dotProduct(R), shininess) * iL.getGreen());
        int b = (int) (kS * Math.pow(v.dotProduct(R), shininess) * iL.getBlue());

        r = Math.min(r, 255);
        r = Math.max(0, r);
        g = Math.min(g, 255);
        g = Math.max(0, g);
        b = Math.min(b, 255);
        b = Math.max(0, b);

        return new Color(r, g, b);
    }



    private Color calcColor(GeoPoint gp) {

        Color ambientLight = _scene.getAmbientLight().getIntensity(gp.getPoint());
        Color emissionLight = gp.getGeometry().getEmission();

        int r = 0;
        int g = 0;
        int b = 0;


        for (Light light : this._scene.getLights()) {

            if (!shaded(light.getL(gp.getPoint()),gp.getPoint(), gp.getGeometry().getNormal(gp.getPoint()))) {
                Color color = calcDiffusiveComp(gp.getGeometry().getMaterial().getKd(),
                        gp.getGeometry().getNormal(gp.getPoint()),
                        light.getL(gp.getPoint()).scale(-1),
                        light.getIntensity(gp.getPoint()));
                r += color.getRed();
                g += color.getGreen();
                b += color.getBlue();

                color = calcSpecularComp(gp.getGeometry().getMaterial().getKs(),
                        _scene.getCamera().getP0().subtract(gp.getPoint()).normalize(),
                        gp.getGeometry().getNormal(gp.getPoint()),
                        light.getL(gp.getPoint()),
                        gp.getGeometry().getMaterial().getShininess(),
                        light.getIntensity(gp.getPoint()));;

                r += color.getRed();
                g += color.getGreen();
                b += color.getBlue();
            }
        }

        r += (ambientLight.getRed() + emissionLight.getRed()) ;
        g += (ambientLight.getGreen() + emissionLight.getGreen()) ;
        b += (ambientLight.getBlue() + emissionLight.getBlue()) ;

        r = Math.max(0,r);
        r = Math.min(r, 255);
        g = Math.max(0,g);
        g = Math.min(g, 255);
        b = Math.max(0,b);
        b = Math.min(b, 255);
        return new Color(r, g, b);
    }

    private static final double EPS = 0.1;

    private boolean shaded(Ray.Vector l, Point3D point, Ray.Vector n) {
        Ray.Vector lightDirection = l.scale(-1);
        Ray.Vector epsVector = n.scale(EPS);
        Point3D newPoint = point.add(epsVector);

        Ray shadowRay = new Ray(newPoint, lightDirection);
        List<GeoPoint> intersectionPoints = getSceneRayIntersections(shadowRay);
        if (intersectionPoints.isEmpty()) {
            return false;
        }

        return true;

    }

}
