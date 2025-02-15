public class CopyingArray {
    public static void main(String[] args) {
        double [] a = new double[3];
        double [] b = a ;
        b[1] = 10;
        System.out.println(a[1]); //prints 10

    }
}
