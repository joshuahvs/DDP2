public class Test2 {
    public static void main(String[] args) {
        int s = (int) 11.0;
        System.out.println(s);
        Cirlce circle = new Cirlce();
        System.out.println(circle.areaCircle(2));

    }
}

class Cirlce{
    public Cirlce(){

    }
    public static double areaCircle(int x){
        return Math.PI * Math.pow(x, 2);
    }
}
