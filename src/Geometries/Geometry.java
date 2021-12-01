package Geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;
import java.util.List;

public abstract class Geometry {
    public Color _emission;
    public abstract List<GeoPoint> findIntersections(Ray ray);
    public abstract Ray.Vector getNormal(Point3D point);

    public Color getEmission() {
        return this._emission;
    }

    public void setEmission(Color color) {
        this._emission = color;
    }
}
