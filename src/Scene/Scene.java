package Scene;
import Geometries.Geometry;

import java.util.List;

public class Scene {
    private String _name;
    private List<Geometry> _geometries;

    public void addGeometry(Geometry geometry) {
        this._geometries.add(geometry);
    }
}
