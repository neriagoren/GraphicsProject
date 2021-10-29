package Unittests;
import Primitives.Point3D;
import Primitives.Ray.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class Point3DTest {

    @Test
    public void testAdd() {
        assertEquals("Wrong point addition", new Point3D(2, 3, 4), new Point3D(1,1,1).add(new Vector(1,2,3)));
    }

    @Test
    public void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test
        assertEquals("Wrong point subtract", new Vector(1, 1, 1),
                new Point3D(2, 3, 4).subtract(new Point3D(1, 2, 3)));

        // =============== Boundary Values Tests ==================
        // TC11: test subtracting same point
        try {
            new Point3D(1, 2, 3).subtract(new Point3D(1, 2, 3));
            fail("Subtract P from P must throw exception");
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testDistance() {
        assertEquals("Wrong distance calculation", Math.sqrt(5), new Point3D(1,1,1).distance(new Point3D(1,2,3)), 0.0001);
    }

    @Test
    public void testEquals() {
        Point3D p1 = new Point3D(1,2,3);
        Point3D p2 = new Point3D(1,2,3);
        assertTrue("Not Equal Points", p1.equals(p2));
    }
}
