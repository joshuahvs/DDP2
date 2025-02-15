import java.util.*;
public class ComputeArea {
    public static void main(String[] args) {
        double radius; //declare variable
        double area; //declare variable
        final double PI = 3.14;

        System.out.println("enter radius: ");
        Scanner input = new Scanner(System.in);
        radius = input.nextInt();
        if (radius>0){
            area = radius*radius*PI;
            System.out.println("the area for radius " + radius + " is " + area);
        } else if (radius == 0) {
            System.out.println("the circle doesn't exist");
        } else{
            System.out.println("radius cannot be less than 0");
        }
        input.close();

    }
}
