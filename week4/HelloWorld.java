public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        Circle c1 = new Circle();
        Circle c2 = new Circle(4.0);  //akan error kalau gaada konstruktor yang sesuai
        Circle c3 = c1;
        System.out.println(c1.radius);
        system.out.println()
    }
}

class Circle{
    double radius;
    //menyediakan contructor tanpa argumen supaya tidak error
    Circle(){

    }
    //klo gaada konstruktor yang ini, maka gk harus nyediain konstruktor tanpa argumen karena java otomatis melakukannya
    Circle(double radius){
        this.radius = radius; // this keyword
    }
}