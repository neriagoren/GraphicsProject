package Elements;

import Primitives.Point3D;

import java.awt.*;

public class PointLight extends Light{

    private Point3D _position;
    private double kC;
    private double kL;
    private double kQ;

    public Color getIntensity(Point3D point) {

        double d = point.distance(_position);
        int r = this._intensity.getRed();
        int g = this._intensity.getGreen();
        int b = this._intensity.getBlue();

        r =  r / (int) (kC + kL * d + kQ * Math.pow(d,2));
        g =  g / (int) (kC + kL * d + kQ * Math.pow(d,2));
        b =  b / (int) (kC + kL * d + kQ * Math.pow(d,2));

        return new Color(r,g,b);
    }

    public Point3D getPosition() {
        return this._position;
    }

    public double getKC() {
        return this.kC;
    }
    public double getKL() {
        return this.kL;
    }
    public double getKQ() {
        return this.kQ;
    }
}
