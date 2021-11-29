package Unittests;

import java.awt.Color;
import java.util.Random;

import org.junit.jupiter.api.Test;

import Renderer.ImageWriter;

class testImageWriter {

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,
                        j % 50 == 0 || i % 50 == 0 ? new Color(255,0,0) : new Color(255,255,0));

        imageWriter.writeToImage();
    }
}
