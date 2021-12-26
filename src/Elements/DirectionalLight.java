package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public class DirectionalLight extends Light{

    private Ray.Vector _direction;

    public Color getIntensity(Point3D point) {
        return this._intensity;
    }

    public Ray.Vector getL(Point3D point) {
        return new Ray.Vector(this._direction).normalize();
    }
}
