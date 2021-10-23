package Unittests;

import Geometries.Plane;
import Primitives.Point3D;
import Primitives.Ray.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlaneTest {

    @Test
    public void testEqualPlanes() {
        Plane plane1 = new Plane(new Point3D(0,0,-2), new Vector(2,3,1));
        Plane plane2 = new Plane(new Point3D(1,1,-7), new Vector(4,6,2));
        assertTrue("Not equal planes", plane1.equals(plane2));
    }
}
