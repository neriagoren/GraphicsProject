package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Ray.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plane extends Geometry {
    private Point3D _point;
    private Vector _normal;
    private double _d;

    public Plane(Point3D point, Vector normal, Color color) {
        this._point = point;
        this._normal = normal;
        this.calculateD();
        this.setEmission(color);
    }


    public Plane(Point3D A, Point3D B, Point3D C, Color color) {
        Vector AB = B.subtract(A);
        Vector AC = C.subtract(A);

        this._point = A;
        this._normal = AB.crossProduct(AC);
        this.calculateD();
        this.setEmission(color);
    }

    public Plane(Plane other) {
        this._point = new Point3D(other.getPoint());
        this._normal = new Vector(other.getNormal());
        this._d = other._d;
        this.setEmission(other.getEmission());
    }

    public void setPoint(Point3D point) {
        this._point = point;
    }
    public Point3D getPoint() {
        return this._point;
    }

    public void setNormal(Vector normal) {
        this._normal = normal.normalize();
    }

    // DO NOT CONFUSE IT WITH THE ABSTRACT METHOD getNormal(Point3D)
    public Vector getNormal() {
        return this._normal;
    }

    public double getD() {
        return this._d;
    }
    // for calculating the d argument of Plane Equation: ax+by+cz+d = 0
    public void calculateD() {
        double x = this._point.getX().getCoordinate();
        double y = this._point.getY().getCoordinate();
        double z = this._point.getZ().getCoordinate();
        double a = this._normal.getHead().getX().getCoordinate();
        double b = this._normal.getHead().getY().getCoordinate();
        double c = this._normal.getHead().getZ().getCoordinate();
        this._d = -x*a - y*b - z*c;
    }

    // IMPLEMENTATION OF ABSTRACT METHODS HERE
    // ==============================================
    public List<GeoPoint> findIntersections(Ray ray) {
        if (ray.getP().equals(this._point)) {
            return null;
        }
        List<GeoPoint> points = new ArrayList<>();
        double t, numerator, denominator;
        numerator = this._normal.dotProduct(this._point.subtract(ray.getP()));
        denominator = this._normal.dotProduct(ray.getDirection());
        if (numerator == 0 || denominator == 0) {
            return null;
        }
        t = numerator/denominator;

        // if t <= 0 return no null
        if (t <= 0) {
            return null;
        }
        Point3D p = ray.getP().add(ray.getDirection().scale(t));

        points.add(new GeoPoint(this, p));
        return points;
    }
    public Vector getNormal(Point3D point) {
        return this._normal.normalize();
    }
    // ==============================================


    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Plane or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Plane)) {
            return false;
        }

        // typecast o to Plane so that we can compare data members
        Plane plane = (Plane) o;

        // Compare the data members and return accordingly
        if (this._normal.normalize().equals(plane.getNormal().normalize())) {
            // checking if the planes are the same plane
            double d = this.getD();

            double a = this._normal.getHead().getX().getCoordinate();
            double b = this._normal.getHead().getY().getCoordinate();
            double c = this._normal.getHead().getZ().getCoordinate();

            double x = plane.getPoint().getX().getCoordinate();
            double y = plane.getPoint().getY().getCoordinate();
            double z = plane.getPoint().getZ().getCoordinate();
            return x * a + y * b + z * c + d == 0 && this.getEmission().equals(plane.getEmission());
        }
        return false;
    }

    @Override
    public String toString() {

        return "Plane\n" + "Point: " + this._point.toString() + ", Normal: " + this._normal.toString()
                + ", Color: " + this.getEmission().toString();
    }
}
