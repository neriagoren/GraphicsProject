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

        Scene scene = new Scene("SHAPES");
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(100) ;
        scene.setBackground(new Color(86, 156, 177));


        scene.addGeometry(new Triangle(new Point3D(0,-300, 200), new Point3D(-125, -150, 200), new Point3D(125,-150,200), Color.YELLOW));

        scene.addGeometry(new Sphere( new Point3D(0, 0, 200), 75,new Color(0,255,0)));

        List<Point3D> hexagon = new ArrayList<>();
        List<Point3D> square = new ArrayList<>();
        List<Point3D> pentagon = new ArrayList<>();

        square.add(new Point3D(250,-100, 200));
        square.add(new Point3D(250,100, 200));
        square.add(new Point3D(350,0, 200));
        square.add(new Point3D(150,0, 200));

        hexagon.add(new Point3D(-250,-100, 200));
        hexagon.add(new Point3D(-250,100, 200));
        hexagon.add(new Point3D(-150,-50, 200));
        hexagon.add(new Point3D(-150,50, 200));
        hexagon.add(new Point3D(-350,50, 200));
        hexagon.add(new Point3D(-350,-50, 200));


        pentagon.add(new Point3D(-0,150, 200));
        pentagon.add(new Point3D(50,335, 200));
        pentagon.add(new Point3D(-50,335, 200));
        pentagon.add(new Point3D(100,225, 200));
        pentagon.add(new Point3D(-100,225, 200));


        scene.addGeometry(new Polygon(hexagon, Color.BLUE));
        scene.addGeometry(new Polygon(square, Color.RED));
        scene.addGeometry(new Polygon(pentagon, Color.MAGENTA));


        ImageWriter imageWriter = new ImageWriter("SHAPES", 500, 500, 500, 500);
        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }
}
