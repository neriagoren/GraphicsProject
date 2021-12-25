package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public class PointLight extends Light {

    private Point3D _position;
    private double kC;
    private double kL;
    private double kQ;

    public PointLight(Color intensity, Point3D position, double kC, double kL, double kQ) {
        this.setIntensity(intensity);
        this.setPosition(position);
        this.setKC(kC);
        this.setKL(kL);
        this.setKQ(kQ);
    }

    public Color getIntensity(Point3D point) {

        double d = point.distance(_position);
        int r = this._intensity.getRed();
        int g = this._intensity.getGreen();
        int b = this._intensity.getBlue();

        r = (int) (r /  (kC + kL * d + kQ * Math.pow(d,2)));
        g = (int) (g /  (kC + kL * d + kQ * Math.pow(d,2)));
        b = (int) (b /  (kC + kL * d + kQ * Math.pow(d,2)));

        if (r < 0) {
            r = 0;
        }
        else if (r > 255) {
            r = 255;
        }

        if (g < 0) {
            g = 0;
        }
        else if (g > 255) {
            g = 255;
        }

        if (b < 0) {
            b = 0;
        }
        else if (b > 255) {
            b = 255;
        }

        return new Color(r,g,b);
    }

    public Point3D getPosition() {
        return this._position;
    }
    public void setPosition(Point3D position) { this._position = position; }

    public double getKC() {
        return this.kC;
    }
    public double getKL() {
        return this.kL;
    }
    public double getKQ() {
        return this.kQ;
    }


    public void setKC(double kC) { this.kC = kC;}
    public void setKL(double kL) { this.kL = kL;}
    public void setKQ(double kQ) { this.kC = kQ;}

    public Ray.Vector getL(Point3D point) {
        return new Ray.Vector(point.subtract(this._position));
    }
}
