package Unittests;
import java.awt.Color;
import java.util.Random;
import org.junit.jupiter.api.Test;
import Renderer.ImageWriter;

class ImageWriterTest {

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 1600, 1600, 25, 25);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                         new Color(255, 255, 255));
            }
        }
    }
}
