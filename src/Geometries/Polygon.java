package Geometries;

import Primitives.Point3D;
import Primitives.Ray.*;

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
    }

    public List<Point3D> getPoints() {
        return this._points;
    }

    public boolean are3PointsOnLine(Point3D A, Point3D B, Point3D C) {
        Vector AB = B.subtract(A);
        Vector AC = C.subtract(A);

        // t*AB = AC       ->  t = AC/AB
        double t = AC.getHead().getX().getCoordinate() / AB.getHead().getX().getCoordinate();
        if (AC.getHead().getY().getCoordinate() / AB.getHead().getY().getCoordinate() == t) {
            return AC.getHead().getZ().getCoordinate() / AB.getHead().getZ().getCoordinate() == t;
        }
        // 3 of the polygon points are not on same line
        return false;
    }

    public boolean isAllPointsOnPlane(Point3D A, Point3D B, Point3D C) {
        if (!are3PointsOnLine(A, B, C)) {
            Vector normal = new Vector(B.subtract(A)).crossProduct(new Vector(C.subtract(A)));
            this._plane = new Plane(A, normal);
            double d = _plane.getD();

            double a = normal.getHead().getX().getCoordinate();
            double b = normal.getHead().getY().getCoordinate();
            double c = normal.getHead().getZ().getCoordinate();

            for (int i = 3; i < this._points.size(); i++) {
                double x = this._points.get(i).getX().getCoordinate();
                double y = this._points.get(i).getY().getCoordinate();
                double z = this._points.get(i).getZ().getCoordinate();

                if (x*a + y*b + z*c + d != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
