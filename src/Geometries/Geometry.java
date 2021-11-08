package Geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.util.List;

public abstract class Geometry {
    public abstract List<Point3D> findIntersections(Ray ray);
    public abstract Ray.Vector getNormal(Point3D point);
}
