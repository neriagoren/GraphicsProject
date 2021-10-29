package Unittests;

import Geometries.Polygon;
import Primitives.Point3D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PolygonTest {

    @Test
    public void test3PointsOnLine() {
        List<Point3D> points = new ArrayList<Point3D>();

        points.add(new Point3D(1,1,1));
        points.add(new Point3D(3,2,2));
        points.add(new Point3D(4,3,3));

        Polygon polygon = new Polygon(points);
    }
}
