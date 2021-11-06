package Scene;
import Elements.Camera;
import Geometries.Geometry;

import java.util.List;

public class Scene {
    private String _name;
    private List<Geometry> _geometries;
    private Camera _camera;

    public void addGeometry(Geometry geometry) {
        this._geometries.add(geometry);
    }
}
