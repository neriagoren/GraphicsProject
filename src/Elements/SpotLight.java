package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public class SpotLight extends PointLight {

    private Ray.Vector _direction;

    public Color getIntensity(Point3D point) {

        Ray.Vector l = getL(point);

        int factor = Math.max(0,(int)l.dotProduct(this._direction));

        double d = point.distance(this.getPosition());
        int r = this._intensity.getRed();
        int g = this._intensity.getGreen();
        int b = this._intensity.getBlue();

        r =  (r * factor) / (int) (this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2));
        g =  (g * factor) / (int) (this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2));
        b =  (b * factor) / (int) (this.getKC() + this.getKL() * d + this.getKQ() * Math.pow(d,2));

        return new Color(r,g,b);
    }
    public Ray.Vector getL(Point3D point) {
        return new Ray.Vector(point.subtract(this.getPosition()));
    }
}
