package Geometries;

public abstract class Geometry {
    public abstract List<Point3D> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point);
}
