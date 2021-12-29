package Unittests;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Geometries.Plane;
import Geometries.Sphere;
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
        Sphere sphere = new Sphere (new Point3D(0.0, 0.0, 1000), 250, new Color(82, 7, 7));
   //     Sphere sphere2 = new Sphere (new Point3D(0, 0.0, 500), 100, new Color(4, 76, 4));
        Material m=new Material(0.5,0.5,20);
     //   Material m2=new Material(0.6,0.9,20);
        sphere.setMaterial(m);
      //  sphere2.setMaterial(m2);
        scene.addGeometry(sphere);
       // scene.addGeometry(sphere2);


        PointLight pointLight = new PointLight(new Color(255,255,255), new Point3D(0, -500, 500), 0, 0.0001, 0.00005);
        scene.addLight(pointLight);

        Plane plane = new Plane(new Point3D(0,500,1000), new Ray.Vector(0,-1,0), Color.BLACK);
        plane.setMaterial(new Material(0.1,0.1,1));

        scene.addGeometry(plane);
        ImageWriter imageWriter;// = new ImageWriter("1", 500,500,2000,2000);
        Renderer render;// = new Renderer(imageWriter, scene);
//        render.renderImage();

        double z = 0;
        String title = "";


        // i^2 + (z-1000)^2 = 500^2
        // i^2 + z^2 - 2000z +1000^2 = 500^2
        // z^2 - 2000z + (i^2 + 10000^2 - 500^2) = 0

//        for (int i = 495;  i >= 0; i-=5) {
//
//            z = (2000 + Math.sqrt((2000*2000) - (4 * (i * i  + 750000)))) /2;
//            pointLight.setPosition(new Point3D(i, -500, z));
//
//            title = String.valueOf(index);
//            imageWriter = new ImageWriter(title, 500, 500, 2000, 2000);
//            render = new Renderer(imageWriter, scene);
//            render.renderImage();
//            index += 5;
//
//        }
//
//        for (int i = 0;  i > -500; i-=5) {
//
//            z = (2000 + Math.sqrt((2000*2000) - (4 * (i * i  + 750000)))) /2;
//            pointLight.setPosition(new Point3D(i, -500, z));
//
//            title = String.valueOf(index);
//            imageWriter = new ImageWriter(title, 500, 500, 2000, 2000);
//            render = new Renderer(imageWriter, scene);
//            render.renderImage();
//            index += 5;
//

//        }

        int index = 1500;


        for (int i = -500;  i < 0; i+=5) {

            z = (2000 - Math.sqrt((2000*2000) - (4 * (i * i  + 750000)))) /2;
            pointLight.setPosition(new Point3D(i, -500, z));

            title = String.valueOf(index);
            imageWriter = new ImageWriter(title, 500, 500, 2000, 2000);
            render = new Renderer(imageWriter, scene);
            render.renderImage();
            index += 5;
        }
    }

//    @Test
//    public void spotLightTest(){
//
//        Scene scene = new Scene("spotLightTest");
//        scene.setBackground(new Color(0, 0, 0));
//        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Ray.Vector(0.0, 0.0, 1.0),new Ray.Vector(0,-1, 0.0)));
//        scene.setScreenDistance(200);
//        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
//
//
//        Sphere sphere = new Sphere(new Point3D(0.0, 0.0, 1000), 500, Color.BLACK);
//        Material m=new Material(0.5,0.5,20);
//        sphere.setMaterial(m);
//        scene.addGeometry(sphere);
//        scene.addLight(new SpotLight(new Color(255, 255, 255), new Point3D(0, -500, 200),
//                new Ray.Vector(1, 1, 1), 0, 0.0001, 0.00005));
//
//        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 2000, 2000);
//
//        Renderer render = new Renderer(imageWriter, scene);
//
//        render.renderImage();
//
//    }
}
