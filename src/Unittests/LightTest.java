package Unittests;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Geometries.Plane;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;
import org.junit.Test;

import java.awt.*;

public class LightTest {


    @Test
    public void pointLightTest(){

        Scene scene = new Scene("pointLightTest");
        scene.setBackground(new Color(59, 124, 192));
        Camera camera = new Camera(new Point3D(0,0,0),
                new Ray.Vector(0,0,1),new Ray.Vector(0,-1, 0));
        scene.setCamera(camera);
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.05));


        Plane plane = new Plane(new Point3D(0,500,200), new Ray.Vector(0,-1,0), Color.BLUE);
        plane.setMaterial(new Material(0,0.5,1));
        scene.addGeometry(plane);


        Sphere sphere = new Sphere(new Point3D(0,0,200), 100, Color.BLACK);
        sphere.setMaterial(new Material(0.5,0.5,10));
        scene.addGeometry(sphere);

        PointLight pointLight = new PointLight(new Color(255,255,255), new Point3D(0, -500, 0), 0, 0.001, 0.005);
        scene.addLight(pointLight);

        ImageWriter imageWriter = new ImageWriter("1", 500,500,2000,2000);
        Renderer render = new Renderer(imageWriter, scene);
        render.renderImage();

    }
}
