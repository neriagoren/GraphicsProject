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

        Ray.Vector l = getL(point);

        int factor = Math.max(0,(int)l.dotProduct(this._direction));

        double d = point.distance(this.getPosition());
        int r = this._intensity.getRed();
        int g = this._intensity.getGreen();
        int b = this._intensity.getBlue();

        r = (int) ((r * factor) / (this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2)));
        g = (int) ((g * factor) /  (this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2)));
        b = (int) ((b * factor) / (this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2)));

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
    public Ray.Vector getL(Point3D point) {
        return new Ray.Vector(point.subtract(this.getPosition()));
    }

    public void setDirection(Ray.Vector direction) {
        this._direction = direction;
    }
    public Ray.Vector getDirection() { return this._direction;}
}
