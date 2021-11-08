package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Ray.Vector;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Geometry {
    private List<Point3D> _points;
    private Plane _plane;

    // minimum 3 points for polygon!
    // check if they are all on same plane!

    public Polygon(List<Point3D> points) {
        try {
            if (points.size() < 3) {
                throw new Exception("must be at least 3 points");
            }
            else {
                // the method isAllPointsOnPlane calculates also the plane of the polygon
                // then assign it to class member - plane
                if(isAllPointsOnPlane(points.get(0), points.get(1), points.get(2))) {
                    this._points = points;
                }
                else {
                    throw new Exception("3 points are on same line");
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
        this._plane = new Plane(other.getPlane());
    }

    // IMPLEMENTATION OF ABSTRACT METHODS HERE
    // ==============================================
    public List<Point3D> findIntersections(Ray ray) {
        return new ArrayList<Point3D>();
    }
    public Vector getNormal(Point3D point) {
        return new Vector(1,1,1);
    }
    // ==============================================


    public Plane getPlane() {
        return this._plane;
    }
    public List<Point3D> getPoints() {
        return this._points;
    }

    public boolean are3PointsOnLine(Point3D A, Point3D B, Point3D C) {
        Vector AB = B.subtract(A);
        Vector AC = C.subtract(A);
        return AB.normalize() == AC.normalize();
    }

    public boolean isAllPointsOnPlane(Point3D A, Point3D B, Point3D C) {
        if (!are3PointsOnLine(A, B, C)) {
            Vector normal = new Vector(B.subtract(A)).crossProduct(new Vector(C.subtract(A)));

            // if the polygon is valid then plane is assigned to class member.
            this._plane = new Plane(A, normal);
            double d = _plane.getD();

            double a = normal.getHead().getX().getCoordinate();
            double b = normal.getHead().getY().getCoordinate();
            double c = normal.getHead().getZ().getCoordinate();

            List<Point3D> points = new ArrayList<Point3D>();
            points.add(A);
            points.add(B);
            points.add(C);

            for (Point3D point : points) {
                double x = point.getX().getCoordinate();
                double y = point.getY().getCoordinate();
                double z = point.getZ().getCoordinate();

                if (x * a + y * b + z * c + d == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
        return this._plane.equals(polygon.getPlane());
    }

    @Override
    public String toString() {
        return "";
    }

}
