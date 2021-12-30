package Geometries;

import Primitives.Point3D;

public class GeoPoint {

    private Geometry geometry;
    private Point3D point;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Point3D getPoint() {
        return point;
    }

    public void setPoint(Point3D point) {
        this.point = point;
    }

    public GeoPoint(Geometry geometry, Point3D point) {
        this.setGeometry(geometry);
        this.setPoint(point);
    }

    public GeoPoint(GeoPoint point) {
        this.geometry = this.getGeometry();
        this.point = point.getPoint();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof GeoPoint)) return false;
        GeoPoint oth = (GeoPoint)obj;
        return this.geometry.equals(oth.geometry) && this.point.equals(oth.point);
    }

    public String toString() {
        return "" + this.geometry.toString() + " " + this.point.toString();
    }
}
