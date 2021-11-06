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

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {

        return new Ray(new Point3D(0,0,0), new Vector(1,1,1));
    }

}
