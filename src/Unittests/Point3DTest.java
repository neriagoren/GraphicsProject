package Unittests;
import Primitives.Point3D;
import Primitives.Ray.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Point3DTest {

    @Test
    public void testAdd() {
        Point3D point = new Point3D(1,1,1);
        Vector vector = new Vector(1,2,3);
        Point3D newPoint = point.add(vector);
        assertEquals(2, newPoint.getX().getCoordinate(), 0.0001 );
        assertEquals(3, newPoint.getY().getCoordinate(), 0.0001 );
        assertEquals(4, newPoint.getZ().getCoordinate(), 0.0001 );
    }

    @Test
    public void testSubtract() {
        Point3D point = new Point3D(1,1,1);
        Point3D other = new Point3D(1,2,3);
        Vector vector = point.subtract(other);
        assertEquals(0, vector.getHead().getX().getCoordinate(), 0.0001);
        assertEquals(-1, vector.getHead().getY().getCoordinate(), 0.0001);
        assertEquals(-2, vector.getHead().getZ().getCoordinate(), 0.0001);
    }
}
