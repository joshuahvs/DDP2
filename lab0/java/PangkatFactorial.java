import java.util.Scanner;
public class PangkatFactorial {
    public static void main(String[] args) {
        // Meminta input kepada user
        Scanner input = new Scanner(System.in);
        System.out.println("masukkan bilangan utama (n):");
        int n = input.nextInt();
        System.out.println("masukkan pemangkatan(m):");
        int m = input.nextInt();
        input.close();

        // Menghitung faktorial
        int hasilFact = 1;
        int tempN = n;
        while (tempN >= 1){
            hasilFact =  hasilFact * tempN;
            tempN--;
        }
        // Menghitung Pangkat
        int hasilPangkat = 1;
        for(;m!=0; m--){
            hasilPangkat = hasilPangkat * n;
        }
        //Mengubah integer menjadi string
        String hasilFactString = String.valueOf(hasilFact);
        String hasilPangkatString = String.valueOf(hasilPangkat);
        // Mencetak outputnya
        System.out.println("n factorial = " + hasilFactString);
        System.out.println("n pangkat m = " + hasilPangkatString);

        
    }
}
