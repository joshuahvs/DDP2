import java.util.Scanner;
public class Nilai {
    public static void main(String[] args) {
        //Meminta input kepada user
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Nama Mahasiswa:");
        String namaMahasiswa = input.nextLine();
        System.out.println("Masukkan Nilai Asli:");
        int nilaiAsli = input.nextInt();
        System.out.println("Masukkan Durasi:");
        int durasi = input.nextInt();
        input.close();

        double nilaiAkhir;

        //Menghitung nilai akhirnya
        if (durasi<60){
            nilaiAkhir = 1.2 * nilaiAsli;
        } else if (60<=durasi && durasi<=70){
            nilaiAkhir = nilaiAsli;
        } else if (70<durasi && durasi<90){
            nilaiAkhir = 0.75 * nilaiAsli;
        } else if (90<= durasi && durasi <=100){
            nilaiAkhir = 0.5 * nilaiAsli;
        } else {
            nilaiAkhir = 0.2 * nilaiAsli;
        }

        //Mengubah nilai akhir yang awalnya double menjadi string
        String nilaiAkhirString = String.valueOf(nilaiAkhir);

        //menampilkan nilai akhirnya
        System.out.println(namaMahasiswa + " mendapatkan nilai akhir " + (nilaiAkhirString));
    }
}
