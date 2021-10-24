package Geometries;

import Primitives.Point3D;
import Primitives.Ray.*;

import java.util.List;

public class Polygon extends Geometry {
    private List<Point3D> _points;

    // minimum 4 points for polygon!
    // check if they are all on same plane!

    public boolean is3PointsOnPlane(Point3D A, Point3D B, Point3D C) {
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
}
