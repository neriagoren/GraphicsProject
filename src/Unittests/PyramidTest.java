package Unittests;
import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class PyramidTest {

    @Test
    public void testRender() {
        Scene scene = new Scene("pointLightTest");
        scene.setBackground(new Color(59, 124, 192));
        Camera camera = new Camera(new Point3D(0,0,0),
                new Ray.Vector(0,0,1),new Ray.Vector(0,-1, 0));
        scene.setCamera(camera);
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.05));

        List<Point3D> vertices = new ArrayList<>();

        vertices.add(new Point3D(0,-100,200));
        vertices.add(new Point3D(100,0,200));
        vertices.add(new Point3D(-100,0,200));
        vertices.add(new Point3D(0,0,150));
        Material m=new Material(0.5,0.5,20);



        PointLight pointLight = new PointLight(new Color(255,255,255), new Point3D(0, -500, 500), 0, 0.0001, 0.00005);
        scene.addLight(pointLight);

        ImageWriter imageWriter = new ImageWriter("1", 500,500,2000,2000);
        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }


}
