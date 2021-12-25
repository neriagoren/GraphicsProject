package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public class AmbientLight extends Light {

    private double kA = 0.1;

    public Color getIntensity(Point3D point) {
        return new Color((int) kA*this._intensity.getRed(),
                (int) kA * this._intensity.getGreen(),
                (int) kA * this._intensity.getBlue());
    }

    public Ray.Vector getL(Point3D point) {
        return null;
    }
}
