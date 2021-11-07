import Primitives.Ray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Ray.Vector up = new Ray.Vector(0,-1,0);
        Ray.Vector to = new Ray.Vector(0,0,1);

        System.out.println(up.crossProduct(to));

    }
}
