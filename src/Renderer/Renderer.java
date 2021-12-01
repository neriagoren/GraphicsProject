package Renderer;

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
                List<Point3D> intersectionPoints = getSceneRayIntersections(ray);

                if (intersectionPoints.isEmpty()) {
                    _imageWriter.writePixel(j, i, _scene.getBackground());
                }
                else {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, calcColor(closestPoint));
                }
            }
        }
        _imageWriter.writeToImage();
    }

    private List<Point3D> getSceneRayIntersections(Ray ray) {
        List<Point3D> intersectionPoints = new ArrayList<>();

        for (Geometry geometry : this._scene.getGeometries()) {
            // findIntersections might return NULL !!!
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
            if (geometryIntersectionPoints != null) {
                intersectionPoints.addAll(geometryIntersectionPoints);
            }
        }
        // intersectionPoints might be empty! (not NULL)
        return intersectionPoints;
    }

    private Point3D getClosestPoint(List<Point3D> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = this._scene.getCamera().getP0();
        Point3D minDistancePoint = null;

        for (Point3D point : intersectionPoints) {
            if (P0.distance(point) < distance) {
                minDistancePoint = new Point3D(point);
                distance = P0.distance(point);
            }
        }
        return minDistancePoint;
    }


    private Color calcColor(Point3D gp) {
        return new Color(255,255,255);
    }
}
