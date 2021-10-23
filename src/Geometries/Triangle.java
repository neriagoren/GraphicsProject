package Geometries;

import Primitives.Point3D;

public class Triangle extends Geometry {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    public Triangle(Point3D A, Point3D B, Point3D C) {
        this._p1 = A;
        this._p2 = B;
        this._p3 = C;
    }

    public Triangle(Triangle other) {
        this._p1 = new Point3D(other.getP1());
        this._p2 = new Point3D(other.getP2());
        this._p3 = new Point3D(other.getP3());
    }

    public Point3D getP1() {
        return this._p1;
    }
    public Point3D getP2() {
        return this._p2;
    }
    public Point3D getP3() {
        return this._p3;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Triangle or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Triangle)) {
            return false;
        }

        // typecast o to Triangle so that we can compare data members
        Triangle triangle = (Triangle) o;

        // Compare the data members and return accordingly

        Point3D[] triangle1 = new Point3D[3];
        Point3D[] triangle2 = new Point3D[3];

        triangle1[0] = this._p1;
        triangle1[1] = this._p2;
        triangle1[2] = this._p3;

        triangle2[0] = triangle.getP1();
        triangle2[1] = triangle.getP2();
        triangle2[2] = triangle.getP3();

        boolean flag;
        for (int i = 0; i <= 2; i++) {
            flag = false;
            for (int j = 0; j <= 2; j++) {
                if (triangle1[i].equals(triangle2[j])) {
                    flag = true;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

}
