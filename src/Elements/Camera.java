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

    public Camera(Point3D p0, Vector to, Vector up) {
        this._P0 = p0;
        this._vup = up;
        this._vto = to;
        this._vright = up.crossProduct(to).scale(-1);
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
        Point3D pc = this._P0.add(this._vto.scale(screenDistance));
        double rY = screenHeight / nY;
        double rX = screenWidth / nX;
        double xj = (j - (double)nX/2)*rX + rX/2;
        double yi = (i - (double)nY/2)*rY + rY/2;

        Point3D pij = pc.add(this._vright.scale(xj).subtract(this._vup.scale(yi)));

        if (xj == 0 || yi == 0) {
            pij = pc;
            if (xj != 0) {
                pij = pij.add(this._vright.scale(xj));
            }
            else if (yi != 0) {
                pij = pij.add(this._vup.scale(-yi));
            }
        }

        Vector vij = pij.subtract(this._P0);

        return new Ray(new Point3D(this._P0), new Vector(vij).normalize());
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
