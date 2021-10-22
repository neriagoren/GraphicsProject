package Unittests;
import Primitives.Point3D;
import org.junit.Test;

import static org.junit.Assert.*;

public class Point3DTest {
    @Test
    public void testPointValue() {
        Point3D p = new Point3D();
        double value = p.getX().getCoordinate();
        assertEquals(0, value,0);
    }
}
