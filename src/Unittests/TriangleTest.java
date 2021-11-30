package Unittests;

import Geometries.Plane;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testEqualTriangles() {
        Triangle t1 = new Triangle(new Point3D(1,1,1), new Point3D(2,2,2), new Point3D(3,3,3), Color.BLACK);
        Triangle t2 = new Triangle(new Point3D(2,2,2), new Point3D(1,1,1), new Point3D(3,3,3), Color.BLACK);
        assertEquals("Not equal", t1, t2);
    }
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Triangle pl = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.BLACK);
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to triangle", new Ray.Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }
    @Test
    public void testFindIntersectionsRay() {
        Triangle tr = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.BLACK);
        Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.BLACK);
        Ray ray;
        List<Point3D> points = new ArrayList<>();

        // ============ Equivalence Partitions Tests ==============
        // TC01: Inside triangle
        points.add(new Point3D(1d / 3, 1d / 3, 1d / 3));
        ray = new Ray(new Point3D(1, 1, 1), new Ray.Vector(-1, -1, -1));
        assertEquals("Bad intersection", points, tr.findIntersections(ray));
        points.clear();

        // TC02: Against edge
        points.add(new Point3D(1,1,-1));
        ray = new Ray(new Point3D(0, 0, -1), new Ray.Vector(1, 1, 0));
        assertEquals("Wrong intersection with plane", points, pl.findIntersections(ray));
        assertNull("Bad intersection", tr.findIntersections(ray));
        points.clear();

        // TC03: Against vertex
        points.add(new Point3D(-0.5, -0.5, 2));
        ray = new Ray(new Point3D(0, 0, 2), new Ray.Vector(-1, -1, 0));
        assertEquals("Wrong intersection with plane", points, pl.findIntersections(ray));
        assertNull("Bad intersection", tr.findIntersections(ray));
        points.clear();

        // =============== Boundary Values Tests ==================
        // TC11: In vertex
        points.add(new Point3D(0, 1, 0));
        ray = new Ray(new Point3D(-1, 0, 0), new Ray.Vector(1, 1, 0));
        assertEquals("Wrong intersection with plane", points, pl.findIntersections(ray));
        assertNull("Bad intersection", tr.findIntersections(ray));
        points.clear();

        // TC12: On edge
        points.add(new Point3D(0.5, 0.5, 0));
        ray = new Ray(new Point3D(-1, -1, 0), new Ray.Vector(1, 1, 0));
        assertEquals("Wrong intersection with plane", points, pl.findIntersections(ray));
        assertNull("Bad intersection", tr.findIntersections(ray));
        points.clear();

        // TC13: On edge continuation
        points.add(new Point3D(-0.5, 1.5, 0));
        ray = new Ray(new Point3D(-2, 0, 0), new Ray.Vector(1, 1, 0));
        assertEquals("Wrong intersection with plane", points, pl.findIntersections(ray));
        assertNull("Bad intersection", tr.findIntersections(ray));
        points.clear();
    }

}
