package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public class SpotLight extends PointLight {

    private Ray.Vector _direction;

    public SpotLight(Color intensity, Point3D position, Ray.Vector direction, double kC, double kL, double kQ) {
        super(intensity, position, kC, kL, kQ);
        this.setDirection(direction);
    }
    public Color getIntensity(Point3D point) {

        Ray.Vector l = getL(point).normalize();

        double factor = Math.max(0,l.dotProduct(this.getDirection().normalize()));

        double d = point.distance(this.getPosition());
        int r = this._intensity.getRed();
        int g = this._intensity.getGreen();
        int b = this._intensity.getBlue();

        double denominator = this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2);
        r = (int) ((r * factor) / denominator);
        g = (int) ((g * factor) / denominator);
        b = (int) ((b * factor) / denominator);

        return new Color(Math.min(r, 255),Math.min(g, 255),Math.min(b, 255));
    }
    public Ray.Vector getL(Point3D point) {
        return new Ray.Vector(point.subtract(this.getPosition())).normalize();
    }

    public void setDirection(Ray.Vector direction) {
        this._direction = direction;
    }
    public Ray.Vector getDirection() { return this._direction;}
}
