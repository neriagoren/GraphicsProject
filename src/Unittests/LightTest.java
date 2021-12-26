package Unittests;

import java.awt.Color;


import org.junit.Test;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

public class LightTest {


    @Test
    public void pointLightTest(){

        Scene scene = new Scene("pointLightTest");
        scene.setBackground(new Color(59, 124, 192));
        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Ray.Vector(0.0, 0.0, 1.0),new Ray.Vector(0,-1, 0.0)));
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
        Sphere sphere = new Sphere (new Point3D(0.0, 0.0, 1000), 500, new Color(0, 0, 0));
        Material m=new Material(0.5,0.5,20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255,255,255), new Point3D(0, -500, 200), 0, 0.0001, 0.00005));

        Plane plane = new Plane(new Point3D(0,500,1000), new Ray.Vector(0,-1,0), Color.GRAY);
        plane.setMaterial(new Material(0.3,0.3,5));

        scene.addGeometry(plane);
        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 2000, 2000);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();
    }

    @Test
    public void spotLightTest(){

        Scene scene = new Scene("spotLightTest");
        scene.setBackground(new Color(0, 0, 0));
        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Ray.Vector(0.0, 0.0, 1.0),new Ray.Vector(0,-1, 0.0)));
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));


        Sphere sphere = new Sphere(new Point3D(0.0, 0.0, 1000), 500, Color.BLACK);
        Material m=new Material(0.5,0.5,20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 255, 255), new Point3D(0, -500, 200),
                new Ray.Vector(1, 1, 1), 0, 0.0001, 0.00005));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 2000, 2000);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }
}
