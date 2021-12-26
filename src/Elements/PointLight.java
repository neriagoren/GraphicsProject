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
        this._intensity = intensity;
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

        double denominator = this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2);

        r = (int) (r /  denominator);
        g = (int) (g /  denominator);
        b = (int) (b /  denominator);

        return new Color(Math.min(r, 255),Math.min(g, 255),Math.min(b, 255));
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
        return new Ray.Vector(point.subtract(this._position)).normalize();
    }
}
