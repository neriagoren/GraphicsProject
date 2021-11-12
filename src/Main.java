import Geometries.Sphere;
import Primitives.Point3D;
import Primitives.Ray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Sphere sphere = new Sphere( new Point3D(1, 0, 0), 1d);
        sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Ray.Vector(1, 1, 0)));

    }
}
