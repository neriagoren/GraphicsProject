package Renderer;

import Geometries.GeoPoint;
import Primitives.Ray;
import Scene.Scene;

import java.awt.*;
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

    }

    public List<GeoPoint> getSceneRayIntersections(Ray ray) {

    }

    public GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {

    }

    public Color calcColor(GeoPoint gp) {

    }

}
