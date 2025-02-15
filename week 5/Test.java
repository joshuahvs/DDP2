public class Test {
    public static void main(String[] args) {
        Cube cube1 = new Cube("Purple", 5.0);
        Cube cube2 = cube1;
        cube2.color = "REd";

        System.out.println(cube1);
        System.out.println(cube1.length);
    }
}

class Cube {
    String color;
    double length;

    public Cube() {

    }

    public Cube(String color, double length) {
        this.color = color;
        this.length = length;
    }

    public String toString() {
        return color;
    }
}