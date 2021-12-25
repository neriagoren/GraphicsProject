import Elements.Light;
import Elements.SpotLight;
import Primitives.Point3D;
import Primitives.Ray;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Light> lights = new ArrayList<>();

        SpotLight light = new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, 150),
                new Ray.Vector(2, 2, 3), 0.1, 0.00001, 0.000005);

        System.out.println(light);

        lights.add(light);
    }
}
