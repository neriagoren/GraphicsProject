package Primitives;

public class Point3D {

    public static final Point3D ZERO = new Point3D(0,0,0);

    private Coordinate _x;
    private Coordinate _y;
    private Coordinate _z;

    public static class Coordinate {
        private double _coordinate;
        public Coordinate() {
            this._coordinate = 0;
        }
        public Coordinate(double coordinate) {
            this._coordinate = coordinate;
        }
        public Coordinate(Coordinate coordinate) {
            this._coordinate = coordinate.getCoordinate();
        }
        public double getCoordinate() {return this._coordinate;}
        public void setCoordinate(double coordinate) {
            this._coordinate = coordinate;
        }

        @Override
        public boolean equals(Object o) {

            // If the object is compared with itself then return true
            if (o == this) {
                return true;
            }

        /* Check if o is an instance of Coordinate or not
          "null instanceof [type]" also returns false */
            if (!(o instanceof Coordinate)) {
                return false;
            }

            // typecast o to Coordinate so that we can compare data members
            Coordinate coordinate = (Coordinate) o;

            // Compare the data members and return accordingly

            // IMPORTANT - comparing with accuracy of 8 decimal places.
            double a = (double)Math.round(this._coordinate * 10000000d) /10000000d;
            double b = (double)Math.round(coordinate.getCoordinate() * 10000000d) /10000000d;

            return Double.compare(a,b) == 0;
        }

        @Override
        public String toString() {
            return Double.toString(this._coordinate);
        }
    }

    public Point3D() {
        this._x = new Coordinate(0);
        this._y = new Coordinate(0);
        this._z = new Coordinate(0);
    }
    public Point3D(double x, double y, double z) {
        this._x = new Coordinate(x);
        this._y = new Coordinate(y);
        this._z = new Coordinate(z);
    }

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this._x = x;
        this._y = y;
        this._z = z;
    }

    public Point3D(Point3D point) {
        this._x = new Coordinate(point.getX());
        this._y = new Coordinate(point.getY());
        this._z = new Coordinate(point.getZ());
    }

    public Coordinate getX() {
        return this._x;
    }
    public Coordinate getY() {
        return this._y;
    }
    public Coordinate getZ() {
        return this._z;
    }

    public void setX(Coordinate x) {
        this._x = x;
    }
    public void setY(Coordinate y) {
        this._y = y;
    }
    public void setZ(Coordinate z) {
        this._z = z;
    }


    public Point3D add(Ray.Vector v) {
        Coordinate x = new Coordinate(this.getX().getCoordinate() + v.getHead().getX().getCoordinate());
        Coordinate y = new Coordinate(this.getY().getCoordinate() + v.getHead().getY().getCoordinate());
        Coordinate z = new Coordinate(this.getZ().getCoordinate() + v.getHead().getZ().getCoordinate());
        return new Point3D(x, y, z);
    }

    public Ray.Vector subtract(Point3D other) {
        Coordinate x = new Coordinate(this._x.getCoordinate() - other.getX().getCoordinate());
        Coordinate y = new Coordinate(this._y.getCoordinate() - other.getY().getCoordinate());
        Coordinate z = new Coordinate(this._z.getCoordinate() - other.getZ().getCoordinate());
        return new Ray.Vector(new Point3D(x, y, z));
    }

    public double distance(Point3D other) {
        double xValue = Math.pow(this._x.getCoordinate() - other.getX().getCoordinate(), 2);
        double yValue = Math.pow(this._y.getCoordinate() - other.getY().getCoordinate(), 2);
        double zValue = Math.pow(this._z.getCoordinate() - other.getZ().getCoordinate(), 2);
        return Math.sqrt(xValue + yValue + zValue);
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Point3D or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Point3D)) {
            return false;
        }

        // typecast o to Point3D so that we can compare data members
        Point3D point = (Point3D) o;

        // Compare the data members and return accordingly
        return this._x.equals(point.getX()) && this._y.equals(point.getY()) && this._z.equals(point.getZ());
    }

    @Override
    public String toString() {
        return "(" + this._x.toString() + ", " + this._y.toString() + ", " + this._z.toString() + ")";
    }
}
