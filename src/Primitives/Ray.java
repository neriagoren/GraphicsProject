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
    public void setDirection(Point3D head) {
        this._direction.setHead(head);
    }
    public Vector getDirection() {
        return this._direction;
    }

    public static class Vector {
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

        @Override
        public boolean equals(Object o) {

            // If the object is compared with itself then return true
            if (o == this) {
                return true;
            }

        /* Check if o is an instance of Vector or not
          "null instanceof [type]" also returns false */
            if (!(o instanceof Vector)) {
                return false;
            }

            // typecast o to Vector so that we can compare data members
            Vector vector = (Vector) o;

            // Compare the data members and return accordingly
            return this._head.equals(vector.getHead());
        }
        @Override
        public String toString() {
            return this._head.toString();
        }
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Ray or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Ray)) {
            return false;
        }

        // typecast o to Ray so that we can compare data members
        Ray ray = (Ray) o;

        // Compare the data members and return accordingly
        return this._p.equals(ray.getP()) && this._direction.equals(ray.getDirection());
    }

    @Override
    public String toString() {
        return "P: " + this._p.toString() + ", Direction: " + this._direction.toString();
    }
}
