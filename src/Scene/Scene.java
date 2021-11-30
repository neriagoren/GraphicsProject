package Scene;
import Elements.Camera;
import Geometries.Geometry;

import java.awt.*;
import java.util.List;

public class Scene {
    private String _name;
    private List<Geometry> _geometries;
    private Camera _camera;
    private double _screenDistance;
    private Color _background;

    public void addGeometry(Geometry geometry) {
        this._geometries.add(geometry);
    }
}
