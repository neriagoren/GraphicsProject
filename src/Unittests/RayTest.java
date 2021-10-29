package Unittests;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Ray.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RayTest {

    @Test
    public void testEquals() {
        Ray ray1 = new Ray(new Point3D(1,1,1), new Vector(1,1,1));
        Ray ray2 = new Ray(new Point3D(1,1,1), new Vector(2,2,2));
        assertTrue("Not equal rays", ray1.equals(ray2));
    }
}
