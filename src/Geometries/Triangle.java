package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Ray.Vector;

import java.awt.*;
import java.util.List;

public class Triangle extends Geometry {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    public Triangle(Point3D A, Point3D B, Point3D C, Color color) {
        this._p1 = A;
        this._p2 = B;
        this._p3 = C;
        this.setEmission(color);
    }

    public Triangle(Triangle other) {
        this._p1 = new Point3D(other.getP1());
        this._p2 = new Point3D(other.getP2());
        this._p3 = new Point3D(other.getP3());
        this.setEmission(other.getEmission());
    }

    // add set methods here - with checks for duplicated points

    public Point3D getP1() {
        return this._p1;
    }
    public Point3D getP2() {
        return this._p2;
    }
    public Point3D getP3() {
        return this._p3;
    }

    // IMPLEMENTATION OF ABSTRACT METHODS HERE
    // ==============================================
    public List<GeoPoint> findIntersections(Ray ray) {

        // finding the intersection of ray and triangle's plane
        Plane plane = new Plane(this._p1, this._p2, this._p3, this.getEmission());
        List<GeoPoint> points = plane.findIntersections(ray);

        // Checking if the intersection point is inside the triangle
        // create 3 planes - pyramid. then check if all signs are the same
        Vector v1 = this._p1.subtract(ray.getP());
        Vector v2 = this._p2.subtract(ray.getP());
        Vector v3 = this._p3.subtract(ray.getP());


        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v2.crossProduct(v3).normalize();
        Vector n3 = v3.crossProduct(v1).normalize();

        if (ray.getDirection().dotProduct(n1) > 0 &&
               ray.getDirection().dotProduct(n2) > 0 &&
                  ray.getDirection().dotProduct(n3) > 0) {
            return points;
        }
        else if (ray.getDirection().dotProduct(n1) < 0 &&
                ray.getDirection().dotProduct(n2) < 0 &&
                ray.getDirection().dotProduct(n3) < 0) {
            return points;
        }
        else {
            return null;
        }
    }
    public Ray.Vector getNormal(Point3D point) {
        Vector v1 = this._p2.subtract(this._p1);
        Vector v2 = this._p3.subtract(this._p1);
        return v1.crossProduct(v2).normalize();
    }
    // ==============================================


    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Triangle or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Triangle)) {
            return false;
        }

        // typecast o to Triangle so that we can compare data members
        Triangle triangle = (Triangle) o;

        // Compare the data members and return accordingly

        Point3D[] triangle1 = new Point3D[3];
        Point3D[] triangle2 = new Point3D[3];

        triangle1[0] = this._p1;
        triangle1[1] = this._p2;
        triangle1[2] = this._p3;

        triangle2[0] = triangle.getP1();
        triangle2[1] = triangle.getP2();
        triangle2[2] = triangle.getP3();

        boolean flag;
        for (int i = 0; i <= 2; i++) {
            flag = false;
            for (int j = 0; j <= 2; j++) {
                if (triangle1[i].equals(triangle2[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return this.getEmission().equals(triangle.getEmission());
    }

    @Override
    public String toString() {
        return "Triangle\n" + this._p1.toString() + " " + this._p2.toString() + " "
                + this._p3.toString() + ", Color: " + this.getEmission().toString();
    }
}
