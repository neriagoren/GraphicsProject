package Renderer;

import Elements.Light;
import Geometries.GeoPoint;
import Geometries.Geometry;
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
                } else {
                    GeoPoint closestPoint = getClosestPoint(intersectionPoints);
//                    if (closestPoint.getGeometry() instanceof Plane && intersectionPoints.size() >= 2) {
//
//                        _imageWriter.writePixel(j, i, closestPoint.getGeometry().getEmission().darker());
//
//                    }
//                    else {
                    _imageWriter.writePixel(j, i, calcColor(closestPoint));

                    // }
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
                minDistancePoint = new GeoPoint(gPoint);
                distance = P0.distance(gPoint.getPoint());
            }
        }
        return minDistancePoint;
    }

    private Color calcDiffusiveComp(double kD, Ray.Vector normal, Ray.Vector l, Color iL) {
        int r = (int) (kD * normal.dotProduct(l) * iL.getRed());
        int g = (int) (kD *  normal.dotProduct(l) * iL.getGreen());
        int b = (int) (kD *  normal.dotProduct(l) * iL.getBlue());

        if (r < 0) {
            r = 0;
        }
        else if (r > 255) {
            r = 255;
        }

        if (g < 0) {
            g = 0;
        }
        else if (g > 255) {
            g = 255;
        }

        if (b < 0) {
            b = 0;
        }
        else if (b > 255) {
            b = 255;
        }

        return new Color(r, g, b);
    }

    private Color calcSpecularComp(double kS, Ray.Vector v, Ray.Vector normal, Ray.Vector l, int shininess, Color iL) {
        Ray.Vector R = l.subtract(normal.scale(2 * l.dotProduct(normal)));
        int r = (int) (kS *  Math.pow(v.dotProduct(R), shininess) * iL.getRed());
        int g = (int) (kS * Math.pow(v.dotProduct(R), shininess) * iL.getGreen());
        int b = (int) (kS * Math.pow(v.dotProduct(R), shininess) * iL.getBlue());

        if (r < 0) {
            r = 0;
        }
        else if (r > 255) {
            r = 255;
        }

        if (g < 0) {
            g = 0;
        }
        else if (g > 255) {
            g = 255;
        }

        if (b < 0) {
            b = 0;
        }
        else if (b > 255) {
            b = 255;
        }


        return new Color(r, g, b);
    }

    private Color calcColor(GeoPoint gp) {
        Color ambientLight = _scene.getAmbientLight().getIntensity(gp.getPoint());
        Color emissionLight = gp.getGeometry().getEmission();

        int r = 0;
        int g = 0;
        int b = 0;

        for (Light light : this._scene.getLights()) {
            try {
                double kd = gp.getGeometry().getMaterial().getKd();
            }
            catch (NullPointerException e) {
                System.out.println("WTF");
            }


//            Color color = calcDiffusiveComp(kd, normal, l, intensity);
//            r += color.getRed();
//            g += color.getGreen();
//            b += color.getBlue();
        }

        if (r < 0) {
            r = 0;
        }
        else if (r > 255) {
            r = 255;
        }

        if (g < 0) {
            g = 0;
        }
        else if (g > 255) {
            g = 255;
        }

        if (b < 0) {
            b = 0;
        }
        else if (b > 255) {
            b = 255;
        }


        Color diffuseLight = new Color(r, g, b);

        r = 0;
        g = 0;
        b = 0;

        for (Light light : this._scene.getLights()) {
            Color color = calcSpecularComp(gp.getGeometry().getMaterial().getKs(),
                    new Ray.Vector(gp.getPoint().subtract(this._scene.getCamera().getP0())),
                    gp.getGeometry().getNormal(gp.getPoint()),
                    light.getL(gp.getPoint()),
                    gp.getGeometry().getMaterial().getShininess(),
                    light.getIntensity(gp.getPoint())
                    );
            r += color.getRed();
            g += color.getGreen();
            b += color.getBlue();
        }

        if (r < 0) {
            r = 0;
        }
        else if (r > 255) {
            r = 255;
        }

        if (g < 0) {
            g = 0;
        }
        else if (g > 255) {
            g = 255;
        }

        if (b < 0) {
            b = 0;
        }
        else if (b > 255) {
            b = 255;
        }



        Color specularLight = new Color(r, g, b);

        r = ambientLight.getRed() + emissionLight.getRed() + diffuseLight.getRed() + specularLight.getRed();
        g = ambientLight.getGreen() + emissionLight.getGreen() + diffuseLight.getGreen() + specularLight.getGreen();
        b = ambientLight.getBlue() + emissionLight.getBlue() + diffuseLight.getBlue() + specularLight.getBlue();


        if (r > 255) {
            r = 255;
        }
        if (g > 255) {
            g = 255;
        }
        if (b > 255) {
            b = 255;
        }

        return new Color(r, g, b);

    }
}
