package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Ray.Vector;

public class Camera {
    Point3D _P0;
    Vector _vup;
    Vector _vright;
    Vector _vto;

    public Camera() {
        this._P0 = new Point3D(0,0,0);
        this._vup = new Vector(0,-1,0);
        this._vright = new Vector(1,0,0);
        this._vto = new Vector(0,0,1);
    }

    public Camera(Point3D p0, Vector up, Vector to) throws IllegalArgumentException {
        if (up.dotProduct(to) == 0) {
            throw new IllegalArgumentException();
        }
        else {
           this._P0 = p0;
           this._vup = up;
           this._vto = to;
           this._vright = up.crossProduct(to);
        }
    }

    public Point3D getP0() {
        return _P0;
    }

    public void setP0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector getVup() {
        return _vup;
    }

    public void setVup(Vector _vup) {
        this._vup = _vup;
    }

    public Vector getVright() {
        return _vright;
    }

    public void setVright(Vector _vright) {
        this._vright = _vright;
    }

    public Vector getVto() {
        return _vto;
    }

    public void setVto(Vector _vto) {
        this._vto = _vto;
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {

        return new Ray(new Point3D(0,0,0), new Vector(1,1,1));
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Vector or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Camera)) {
            return false;
        }

        // typecast o to Camera so that we can compare data members
        Camera camera = (Camera) o;

        // Compare the data members and return accordingly
        return this._P0.equals(camera.getP0()) && this._vup.equals(camera.getVup())
                && this._vto.equals(camera.getVto()) && this._vright.equals(camera.getVright());
    }

    @Override
    public String toString() {
        return this._P0.toString() + ", vUp: " + this._vup.toString()
                + ", Vright: " + this._vright.toString()
                + ", Vto: " + this._vto.toString();
    }
}
