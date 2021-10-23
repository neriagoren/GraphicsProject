package Unittests;

import Geometries.Triangle;
import Primitives.Point3D;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TriangleTest {

    @Test
    public void testEqualTriangles() {
        Triangle t1 = new Triangle(new Point3D(1,1,1), new Point3D(2,2,2), new Point3D(3,3,3));
        Triangle t2 = new Triangle(new Point3D(2,2,2), new Point3D(1,1,1), new Point3D(3,3,3));
        assertTrue("Not equal",t1.equals(t2));
    }
}
