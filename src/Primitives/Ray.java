package Primitives;

public class Ray {
    Point3D _p;
    Vector _direction;

    public void setP(Point3D point) {
        this._p = point;
    }
    public Point3D getP() {
        return this._p;
    }
    private class Vector {

        private Point3D _head;

        public Vector(double x, double y, double z) {
            this._head = new Point3D(x, y, z);
            if (Point3D.ZERO.equals(this._head)) {
                throw new IllegalArgumentException("Zero vector is not allowed");
            }
        }

        public Vector(Point3D p) {
            if (Point3D.ZERO.equals(p)) {
                throw new IllegalArgumentException("Zero vector is not allowed");
            }
            this._head = new Point3D(p);
        }

        public Vector(Vector other) {
            this._head = new Point3D(other.getHead());
        }

        public Point3D getHead() {
            return this._head;
        }

        public void setHead(Point3D point) {
            this._head = point;
        }
    }
}
