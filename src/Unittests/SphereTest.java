package Unittests;

import Geometries.Sphere;
import Primitives.Point3D;
import Primitives.Ray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void testEquals() {
        Sphere sphere1 = new Sphere(new Point3D(1,1,1), 5);
        Sphere sphere2 = new Sphere(new Point3D(1,1,1), 5);
        assertTrue("Not Equal Spheres", sphere1.equals(sphere2));
    }

    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Sphere sph = new Sphere(new Point3D(0, 0, 0), 1d);
        assertEquals("Bad normal to sphere", new Ray.Vector(0, 0, 1), sph.getNormal(new Point3D(0, 0, 1)));
    }

    @Test
    public void testFindIntersectionsRay() {
        Sphere sphere = new Sphere( new Point3D(1, 0, 0), 1d);
        List<Point3D> exp = new ArrayList<>();
        // ============ Equivalence Partitions Tests ==============
        Point3D gp1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D gp2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        exp.add(gp1);
        exp.add(gp2);

        List<Point3D> points = new ArrayList<>();

        // TC01: Ray's line is outside the sphere (0 points)
        //assertNull("Ray's line out of sphere",
        //      sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Ray.Vector(1, 1, 0))));

        // TC02: Ray starts before and crosses the sphere (2 points)
        List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Ray.Vector(3, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).getX().getCoordinate() > result.get(1).getX().getCoordinate()) {
            Point3D temp = result.get(0);
            Point3D temp2 = result.get(1);
            result.add(temp2);
            result.add(temp);
        }
        assertEquals("Ray crosses sphere", exp, result);

        // TC03: Ray starts inside the sphere (1 point)
        points.add(gp2);
        assertEquals("Ray from inside sphere", points,
                sphere.findIntersections(new Ray(new Point3D(0.5, 0.5, 0), new Ray.Vector(3, 1, 0))));
        points.clear();

        // TC04: Ray starts after the sphere (0 points)
        assertNull("Sphere behind Ray",
                sphere.findIntersections(new Ray(new Point3D(2, 1, 0), new Ray.Vector(3, 1, 0))));

        // =============== Boundary Values Tests ==================
        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        points.add(new Point3D(2,0,0));
        assertEquals("Ray from sphere inside", points,
                sphere.findIntersections(new Ray(new Point3D(1, -1, 0), new Ray.Vector(1, 1, 0))));
        points.clear();

        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull("Ray from sphere outside",
                sphere.findIntersections(new Ray(new Point3D(2, 0, 0), new Ray.Vector(1, 1, 0))));

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        result = sphere.findIntersections(new Ray(new Point3D(1, -2, 0), new Ray.Vector(0, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).getY().getCoordinate() > result.get(1).getY().getCoordinate()) {
            Point3D temp = result.get(0);
            Point3D temp2 = result.get(1);
            result.add(temp2);
            result.add(temp);
        }
        points.add(new Point3D(1,-1,0));
        points.add(new Point3D(1,1,0));
        assertEquals("Line through O, ray crosses sphere",
                points, result);
        points.clear();

        // TC14: Ray starts at sphere and goes inside (1 points)
        points.add(new Point3D(1,1,0));
        assertEquals("Line through O, ray from and crosses sphere", points,
                sphere.findIntersections(new Ray(new Point3D(1, -1, 0), new Ray.Vector(0, 1, 0))));
        points.clear();

        // TC15: Ray starts inside (1 points)
        points.add(new Point3D(1,1,0));
        assertEquals("Line through O, ray from inside sphere", points,
                sphere.findIntersections(new Ray(new Point3D(1, 0.5, 0), new Ray.Vector(0, 1, 0))));
        points.clear();

        // TC17: Ray starts at sphere and goes outside (0 points)
        assertNull("Line through O, ray from sphere outside",
                sphere.findIntersections(new Ray(new Point3D(1, 1, 0), new Ray.Vector(0, 1, 0))));

        // TC18: Ray starts after sphere (0 points)
        assertNull("Line through O, ray outside sphere",
                sphere.findIntersections(new Ray(new Point3D(1, 2, 0), new Ray.Vector(0, 1, 0))));

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertNull("Tangent line, ray before sphere",
                sphere.findIntersections(new Ray(new Point3D(0, 1, 0), new Ray.Vector(1, 0, 0))));
        // TC20: Ray starts at the tangent point
        assertNull("Tangent line, ray at sphere",
                sphere.findIntersections(new Ray(new Point3D(1, 1, 0), new Ray.Vector(1, 0, 0))));
        // TC21: Ray starts after the tangent point
        assertNull("Tangent line, ray after sphere",
                sphere.findIntersections(new Ray(new Point3D(2, 1, 0), new Ray.Vector(1, 0, 0))));

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's
        // center line
        assertNull("Ray orthogonal to ray head -> O line",
                sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Ray.Vector(0, 0, 1))));

    }
}
