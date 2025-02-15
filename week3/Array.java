import java.util.*;
public class Array {
    public static void main(String[] args) {
        // int [] a = {1,2,3,4};
        // int [] b = {1,2,3,a[0]};
        // System.err.println(a);
        // System.out.println(Arrays.toString(a)); // [1,2,3,4]


        // int [] aa = {1,2,3,4};
        // int [] bb = {4,5};
        // int [] [] cc = {aa,bb};
        // System.out.println(cc); //[[I@251a69d7
        // System.out.println(Arrays.toString(cc)); //[[I@7344699f, [I@6b95977]

        // System.out.println(Arrays.deepToString(cc)); //untuk mencetak isi elemen array dua dimensi

        // for (int[] elem:cc){
        //     System.out.println(Arrays.toString(elem));
        // }

        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        System.out.println(arr1 == arr2);
    }
}
