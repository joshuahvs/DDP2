import java.util.*;

public class Arr01 {
    public static void main(String[] args) {
        
        int[][] arrA = {{2,5,1}, {1,2,0},{0,5,1}};
        int[] arrB = new int[9];
        int c = 0;

        for (int j=0; j<3;j++){
            for(int h =0; h <3;h++){
                arrB[c] = arrA[j][h];
                c++;
            }
        }

        for (int i=0;i<9;i++){
            System.out.println(arrB[i]);
    }
}

}