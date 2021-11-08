package Geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends Geometry {
    private Point3D _center;
    private double _radius;

    // default sphere
    public Sphere() {
        this._center = new Point3D(0,0,0);
        this._radius = 1;
    }

    public Sphere(Point3D center, double radius) {
        this._center = center;
        this._radius = radius;
    }

    public Sphere(Sphere sphere) {
        this._center = new Point3D(sphere.getCenter());
        this._radius = sphere.getRadius();
    }

    public void setCenter(Point3D center) {
        this._center = center;
    }
    public Point3D getCenter() {
        return this._center;
    }

    public void setRadius(double radius) {
        this._radius = radius;
    }
    public double getRadius() {
        return this._radius;
    }

    // IMPLEMENTATION OF ABSTRACT METHODS HERE
    // ==============================================
    public List<Point3D> findIntersections(Ray ray) {
        return new ArrayList<Point3D>();
    }
    public Ray.Vector getNormal(Point3D point) {
        return new Ray.Vector(1,1,1);
    }
    // ==============================================


    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Sphere or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Sphere)) {
            return false;
        }

        // typecast o to Sphere so that we can compare data members
        Sphere sphere = (Sphere) o;

        // Compare the data members and return accordingly
        return this._center.equals(sphere.getCenter()) && this._radius == sphere.getRadius();
    }

    @Override
    public String toString() {
        return "Sphere\nCenter: " + this._center.toString() + ", Radius: " + this._radius;
    }
}
