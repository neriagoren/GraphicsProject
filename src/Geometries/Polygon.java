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
    public List<GeoPoint> findIntersections(Ray ray) {

        // finding the intersection of ray and polygon's plane
        Plane plane = new Plane(this._points.get(0), this._points.get(1), this._points.get(2), this.getEmission());
        List<GeoPoint> points = plane.findIntersections(ray);

        if (isPointInPolygon(points.get(0).getPoint())) {
            return points;
        }
        else {
            return null;
        }
    }

    public boolean isPointInPolygon( Point3D p )
    {
        double minX = this._points.get(0).getX().getCoordinate();
        double maxX = this._points.get(0).getX().getCoordinate();
        double minY = this._points.get(0).getY().getCoordinate();
        double maxY = this._points.get(0).getX().getCoordinate();
        for ( int i = 1 ; i < this._points.size() ; i++ )
        {
            Point3D q = this._points.get(i);
            minX = Math.min( q.getX().getCoordinate(), minX );
            maxX = Math.max( q.getX().getCoordinate(), maxX );
            minY = Math.min( q.getY().getCoordinate(), minY );
            maxY = Math.max( q.getY().getCoordinate(), maxY );
        }

        if ( p.getX().getCoordinate() < minX || p.getX().getCoordinate() > maxX || p.getY().getCoordinate() < minY || p.getY().getCoordinate() > maxY )
        {
            return false;
        }

        // https://wrf.ecse.rpi.edu/Research/Short_Notes/pnpoly.html
        boolean inside = false;
        for ( int i = 0, j = this._points.size() - 1 ; i < this._points.size() ; j = i++ )
        {
            if ( ( this._points.get(i).getY().getCoordinate() > p.getY().getCoordinate() ) != ( this._points.get(j).getY().getCoordinate() > p.getY().getCoordinate() ) &&
                    (p.getX().getCoordinate()< ( this._points.get(j).getX().getCoordinate() - this._points.get(i).getX().getCoordinate() ) * ( p.getY().getCoordinate() - this._points.get(i).getY().getCoordinate() ) / ( this._points.get(i).getY().getCoordinate() - this._points.get(i).getY().getCoordinate() ) + this._points.get(i).getX().getCoordinate() ))
            {
                inside = !inside;
            }
        }

        return inside;
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
