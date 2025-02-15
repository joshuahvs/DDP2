public class Recursion {
    public static void main(String[] args) {

        // int counter = 0;
        // for (int i = 1; i<=5; i++){
        //     for (int j=1; j<5; j++){
        //         for (int k = 1; k<=5; k++){
        //             if (k==3){
        //                 break;
        //             }
        //             counter++;
                    
        //         }
        //     }
        // }
        // // System.out.println(counter);
        // System.out.println(apaHayo(7));
    }

    public static int apaHayo (int n){
        if (n<=2){
            return 1;
        }else{
            System.out.println("haha");
            return apaHayo(n-1)+ apaHayo(n-2)+ apaHayo(n-3);
        }
    }
}
