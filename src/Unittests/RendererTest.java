package Unittests;


import Elements.Camera;
import Geometries.Polygon;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class RendererTest {

    @Test
    public void SHREK() {

        Scene scene = new Scene("SHREK");
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(100) ;
        scene.setBackground(new Color(0,0,0));

        scene.addGeometry(new Triangle(new Point3D(0, 50, 150), new Point3D(20, 2, 150), new Point3D(39, 50, 150),new Color(78, 49, 5)));
        scene.addGeometry(new Triangle(new Point3D(0, 50, 150), new Point3D(-20, 2, 150), new Point3D(-39, 50, 150),new Color(78, 49, 5)));

        scene.addGeometry(new Sphere( new Point3D(0, -25, 200), 25,new Color(0,255,0)));
        scene.addGeometry(new Sphere( new Point3D(0, 50, 200), 50,new Color(255,255,255)));

        scene.addGeometry(new Triangle(new Point3D(-50, -50, 200), new Point3D(-50, -40, 200), new Point3D(-25, -35, 200),new Color(0,255,0)));
        scene.addGeometry(new Triangle(new Point3D(50, -50, 200), new Point3D(50, -40, 200), new Point3D(25, -35, 200),new Color(0,255,0)));

        List<Point3D> polygon = new ArrayList<>();

        polygon.add(new Point3D(25,0, 190));
        polygon.add(new Point3D(50,0, 190));
        polygon.add(new Point3D(25,25, 190));
        polygon.add(new Point3D(50,25, 190));
        scene.addGeometry(new Polygon( polygon, new Color(255,0,255)));


        ImageWriter imageWriter = new ImageWriter("SHREK", 500, 500, 500, 500);
        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void gridPaint(){
        ImageWriter grid = new ImageWriter("grid", 500, 500, 500, 500);
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                grid.writePixel(j,i,i % 50 == 0 || j % 50 == 0 ? Color.PINK : Color.WHITE);
            }
        }
        grid.writeToImage();
    }

}
