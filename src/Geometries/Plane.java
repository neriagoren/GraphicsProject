package Geometries;

import Primitives.Point3D;
import Primitives.Ray.*;

public class Plane extends Geometry {
    private Point3D _point;
    private Vector _normal;
    private double _d;

    public Plane(Point3D point, Vector normal) {
        this._point = point;
        this._normal = normal;
        this.calculateD();
    }

    public Plane(Plane other) {
        this._point = new Point3D(other.getPoint());
        this._normal = new Vector(other.getNormal());
        this._d = other._d;
    }

    public void setPoint(Point3D point) {
        this._point = point;
    }
    public Point3D getPoint() {
        return this._point;
    }

    public void setNormal(Vector normal) {
        this._normal = normal;
    }
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
        try {
            this._normal.crossProduct(plane.getNormal());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Might be parallel planes!");

            // testing if the planes are the same plane

            double d = this.getD();

            double a = this._normal.getHead().getX().getCoordinate();
            double b = this._normal.getHead().getY().getCoordinate();
            double c = this._normal.getHead().getZ().getCoordinate();

            double x = plane.getPoint().getX().getCoordinate();
            double y = plane.getPoint().getY().getCoordinate();
            double z = plane.getPoint().getZ().getCoordinate();
            return x*a + y*b + z*c + d == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Plane\n" + "Point: " + this._point.toString() + ", Normal: " + this._normal.toString();
    }
}
