package Unittests;

import Geometries.Polygon;
import Primitives.Point3D;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PolygonTest {

    @Test
    public void testEquals() {

        List<Point3D> points1 = new ArrayList<Point3D>();
        List<Point3D> points2 = new ArrayList<Point3D>();

        points1.add(new Point3D(1,0,0));
        points1.add(new Point3D(0,1,0));
        points1.add(new Point3D(0,0,0));
        points1.add(new Point3D(1,1,0));

        points2.add(new Point3D(0,1,0));
        points2.add(new Point3D(1,0,0));
        points2.add(new Point3D(1,1,0));
        points2.add(new Point3D(0,0,0));

        Polygon polygon1 = new Polygon(points1, Color.BLUE);
        Polygon polygon2 = new Polygon(points2, Color.BLUE);

        assertEquals("Not equal polygons", polygon1, polygon2);

    }
}
