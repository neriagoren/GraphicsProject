package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Ray.Vector;

import java.awt.*;
import java.util.List;

public class Polygon extends Geometry {
    private List<Point3D> _points;

    // minimum 3 points for polygon!
    // check if they are all on same plane!

    public Polygon(List<Point3D> points, Color color) {
        try {
            if (points.size() < 3) {
                throw new Exception("must be at least 3 points");
            }
            else {
                // the method isAllPointsOnPlane calculates also the plane of the polygon
                if(isAllPointsOnPlane(points)) {
                    this._points = points;
                    this.setEmission(color);
                }
                else {
                    throw new Exception("Error initializing polygon");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Polygon(Polygon other) {
        for (int i = 0; i < other.getPoints().size(); i++) {
            this._points.add(new Point3D(other.getPoints().get(i)));
        }
        this.setEmission(other.getEmission());
    }

    // IMPLEMENTATION OF ABSTRACT METHODS HERE
    // ==============================================

    // WORKS ONLY WITH CONVEX POLYGONS!
    public List<GeoPoint> findIntersections(Ray ray) {
        Triangle triangle;
        for (Point3D A : _points) {
            for (Point3D B : _points) {
                for (Point3D C : _points) {
                    if (!A.equals(B) && !A.equals(C) && !B.equals(C)) {
                        triangle = new Triangle(A, B, C, this._emission);
                        List<GeoPoint> points = triangle.findIntersections(ray);
                        if (points != null) {
                            return points;
                        }
                    }
                }
            }
        }

        return null;
    }

    public Point3D[] sortVertexes() {

        Point3D[] vertexes = new Point3D[_points.size()];
        vertexes[0] = new Point3D(_points.get(0));
        Point3D point;
        for (int i = 0; i < vertexes.length - 1; i++) {
            vertexes[i+1] = closest(vertexes, vertexes[i]);

        }
        return vertexes;
    }

    public Point3D closest(Point3D[] vertexes, Point3D point) {
        double dis1 = Double.MAX_VALUE;
        Point3D close = new Point3D();

        for (int i = 0; i < _points.size(); i++) {
            if (!_points.get(i).equals(point) && !isThere(vertexes, _points.get(i))) {
                if (_points.get(i).distance(point) < dis1) {
                    dis1 = _points.get(i).distance(point);
                    close = new Point3D(_points.get(i));
                }
            }

        }
        return close;
    }

    public boolean isThere(Point3D[] vertexes, Point3D point) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] != null) {
                if (vertexes[i].equals(point)) {
                    return true;
                }
            }
        }
        return false;
    }



    public Vector getNormal(Point3D point) {
        Vector v1 = this._points.get(1).subtract(this._points.get(0));
        Vector v2 = this._points.get(2).subtract(this._points.get(0));
        return v1.crossProduct(v2).normalize();
    }
    // ==============================================



    public List<Point3D> getPoints() {
        return this._points;
    }


    public boolean isAllPointsOnPlane(List<Point3D> points) {
        Vector normal = new Vector(points.get(1).subtract(points.get(0))).crossProduct(new Vector(points.get(2).subtract(points.get(0))));

        Plane plane = new Plane(points.get(0), normal, this._emission);
        double d = plane.getD();

        double a = normal.getHead().getX().getCoordinate();
        double b = normal.getHead().getY().getCoordinate();
        double c = normal.getHead().getZ().getCoordinate();


        for (Point3D point : points) {
            double x = point.getX().getCoordinate();
            double y = point.getY().getCoordinate();
            double z = point.getZ().getCoordinate();

            if (x * a + y * b + z * c + d != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Polygon or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Polygon)) {
            return false;
        }

        // typecast o to Coordinate so that we can compare data members
        Polygon polygon = (Polygon) o;

        // Compare the data members and return accordingly
        boolean flag;
        for (Point3D pointThis : this._points) {
            flag = false;
            for (Point3D pointOther : polygon.getPoints()) {
                if (pointThis.equals(pointOther)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return this.getEmission().equals(polygon.getEmission());
    }

    @Override
    public String toString() {
        String polygon = "";

        for (Point3D point : this._points) {
            polygon += point.toString();
            polygon += " ";
        }
        polygon += ", Color: " + this.getEmission().toString();
        return polygon;
    }
}
