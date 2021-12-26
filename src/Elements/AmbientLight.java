package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public class AmbientLight extends Light {

    private double _kA = 0.1;
//
    public AmbientLight(Color color, double kA) {
        this._intensity = color;
        this._kA = kA;
    }
    public Color getIntensity(Point3D point) {
        return new Color((int) (this._kA*this._intensity.getRed()),
                (int) (this._kA * this._intensity.getGreen()),
                (int) (this._kA * this._intensity.getBlue()));
    }

    public Ray.Vector getL(Point3D point) {
        return null;
    }

    public void setKA(double kA) { this._kA = kA;}
    public double getKA() { return this._kA;}
}
