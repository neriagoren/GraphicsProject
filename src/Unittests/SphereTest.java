package Unittests;

import Geometries.Sphere;
import Primitives.Point3D;
import org.junit.Test;
import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void testEquals() {
        Sphere sphere1 = new Sphere(new Point3D(1,1,1), 5);
        Sphere sphere2 = new Sphere(new Point3D(1,1,1), 5);
        assertTrue("Not Equal Spheres", sphere1.equals(sphere2));
    }
}
