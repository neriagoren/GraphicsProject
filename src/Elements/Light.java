package Elements;

import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;

public abstract class Light {
    public Color _intensity;
    public abstract Color getIntensity(Point3D point);
    public abstract Ray.Vector getL(Point3D point);

    public void setIntensity(Color intensity) {this._intensity = intensity;}
    public Color getIntensity () {
        return this._intensity;
    }
}
