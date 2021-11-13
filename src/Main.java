import Elements.Camera;
import Primitives.Point3D;
import Primitives.Ray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Camera camera = new Camera(Point3D.ZERO, new Ray.Vector(0, 0, 1), new Ray.Vector(0, -1, 0));

        Ray ray = camera.constructRayThroughPixel(4, 4, 1, 1, 10, 8, 8);

        System.out.println(ray);
    }
}
