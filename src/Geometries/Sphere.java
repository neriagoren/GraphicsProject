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

        // ------------------------------------------------------------------------------------------------------------- //
        // This method is implemented using the instructions at: http://cosinekitty.com/raytrace/chapter06_sphere.html   //
        // ------------------------------------------------------------------------------------------------------------- //

        List<Point3D> points = new ArrayList<>();

        Point3D p0 = ray.getP();
        Ray.Vector v = ray.getDirection();
        Point3D C = this._center;
        double R = this._radius;

        // The scalars we need to find
        double t1, t2;

        // Creating the discriminant
        double a = v.dotProduct(v);
        double b = 2*v.dotProduct(p0.subtract(this._center));
        double c = p0.subtract(this._center).dotProduct(p0.subtract(this._center)) - Math.pow(this._radius,2);
        double discriminant = Math.pow(b, 2) - 4*a*c;

        // if discriminant = 0 it means that Ray is tangent with the Sphere
        if (discriminant <=0) {
            return null;
        }

        t1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        t2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        // if both u1,u2 <= 0, it means that the Sphere is behind Ray or Ray starts on Sphere toward outside
        if (t1 <= 0 && t2 <= 0) {
            return null;
        }

        // Ray starts from outside of Sphere
        if (p0.distance(C) > R) {
            if (t1 > 0) {
                // append point
                points.add(new Point3D(p0.add(v.scale(t1))));

            }
            if (t2 > 0) {
                // append point
                points.add(new Point3D(p0.add(v.scale(t2))));
            }
            return points;
        }
        // Ray start from inside of Sphere
        else if (p0.distance(C) < R) {
            if (t1 > 0) {
                // append point
                points.add(new Point3D(p0.add(v.scale(t1))));
                return points;
            }
            if (t2 > 0) {
                // append point
                points.add(new Point3D(p0.add(v.scale(t2))));
                return points;
            }
        }
        // Ray starts on Sphere's surface
        else {
            if (t1 > 0) {
                // append point
                points.add(new Point3D(p0.add(v.scale(t1))));
                return points;
            }
            if (t2 > 0) {
                // append point
                points.add(new Point3D(p0.add(v.scale(t2))));
                return points;
            }
        }
        return null;
    }
    public Ray.Vector getNormal(Point3D point) {
        return point.subtract(this._center).normalize();
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
