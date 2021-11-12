package Primitives;

public class Ray {

    Point3D _p;
    Vector _direction;

    public Ray(Point3D p, Vector v) {
        this._p = p;
        this._direction = v;
    }

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

        public double length() {
            double x = Math.pow(this._head.getX().getCoordinate(), 2);
            double y = Math.pow(this._head.getY().getCoordinate(), 2);
            double z = Math.pow(this._head.getZ().getCoordinate(), 2);
            return Math.sqrt(x + y + z);
        }

        public Vector normalize() {
            double length = this.length();
            double x = this._head.getX().getCoordinate() / length;
            double y = this._head.getY().getCoordinate() / length;
            double z = this._head.getZ().getCoordinate() / length;
            return new Vector(x, y, z);
        }

        public Vector add(Vector other) {
            return new Vector(this._head.add(other));
        }

        public Vector subtract(Vector other) {
            return new Vector(this._head.subtract(other.getHead()));
        }

        public Vector scale(double scalar) {
            double x = scalar * this._head.getX().getCoordinate();
            double y = scalar * this._head.getY().getCoordinate();
            double z = scalar * this._head.getZ().getCoordinate();
            return new Vector(x, y, z);
        }

        public Vector crossProduct(Vector other) {
            double u1 = this._head.getX().getCoordinate();
            double u2 = this._head.getY().getCoordinate();
            double u3 = this._head.getZ().getCoordinate();
            double v1 = other.getHead().getX().getCoordinate();
            double v2 = other.getHead().getY().getCoordinate();
            double v3 = other.getHead().getZ().getCoordinate();
            return new Vector(u2*v3-u3*v2,u3*v1-u1*v3,u1*v2-u2*v1);
        }

        public double dotProduct(Vector other) {
            double u1 = this._head.getX().getCoordinate();
            double u2 = this._head.getY().getCoordinate();
            double u3 = this._head.getZ().getCoordinate();
            double v1 = other.getHead().getX().getCoordinate();
            double v2 = other.getHead().getY().getCoordinate();
            double v3 = other.getHead().getZ().getCoordinate();
            return (u1*v1 + u2*v2 + u3*v3);
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
            // using linear independence equations

            Point3D.Coordinate x = this._head.getX();
            Point3D.Coordinate y = this._head.getY();
            Point3D.Coordinate z = this._head.getZ();

            Point3D.Coordinate a = vector.getHead().getX();
            Point3D.Coordinate b = vector.getHead().getY();
            Point3D.Coordinate c = vector.getHead().getZ();
            return x.equals(a) && y.equals(b) && z.equals(c);
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
        return this._p.equals(ray.getP()) && this._direction.normalize().equals(ray.getDirection().normalize());
    }

    @Override
    public String toString() {
        return "P: " + this._p.toString() + ", Direction: " + this._direction.toString();
    }
}
