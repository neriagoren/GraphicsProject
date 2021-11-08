package Geometries;

import Primitives.Point3D;
import Primitives.Ray.*;

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

        return AB.normalize() == AC.normalize();
    }

    public boolean isAllPointsOnPlane(Point3D A, Point3D B, Point3D C) {
        if (!are3PointsOnLine(A, B, C)) {
            Vector normal = new Vector(B.subtract(A)).crossProduct(new Vector(C.subtract(A)));
            this._plane = new Plane(A, normal);
            double d = _plane.getD();

            double a = normal.getHead().getX().getCoordinate();
            double b = normal.getHead().getY().getCoordinate();
            double c = normal.getHead().getZ().getCoordinate();

            List<Point3D> points = new ArrayList<Point3D>();
            points.add(A);
            points.add(B);
            points.add(C);

            for (int i = 0; i < points.size(); i++) {
                double x = points.get(i).getX().getCoordinate();
                double y = points.get(i).getY().getCoordinate();
                double z = points.get(i).getZ().getCoordinate();

                if (x*a + y*b + z*c + d != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
