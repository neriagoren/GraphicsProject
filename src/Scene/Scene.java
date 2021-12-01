package Scene;
import Elements.Camera;
import Geometries.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private String _name;
    private List<Geometry> _geometries;
    private Camera _camera;
    private double _screenDistance;
    private Color _background;

    public Scene(String name) {
        this._name = name;
        this._background = Color.BLACK;
        this._geometries = new ArrayList<>();
    }

    public Scene(String name, List<Geometry> geometries, Camera camera, double distance, Color background) {
        this._name = name;
        this._geometries = geometries;
        this._camera = camera;
        this._screenDistance = distance;
        this._background = background;
    }

    public void addGeometry(Geometry geometry) {
        this._geometries.add(geometry);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public List<Geometry> getGeometries() {
        return this._geometries;
    }

    public void setGeometries(List<Geometry> geometries) {
        this._geometries = geometries;
    }

    public Camera getCamera() {
        return this._camera;
    }

    public void setCamera(Camera camera) {
        this._camera = camera;
    }

    public double getScreenDistance() {
        return this._screenDistance;
    }

    public void setScreenDistance(double screenDistance) {
        this._screenDistance = screenDistance;
    }

    public Color getBackground() {
        return this._background;
    }

    public void setBackground(Color background) {
        this._background = background;
    }
}
