import java.util.Scanner; //import java.util.Scanner supaya bisa menggunakan scanner
public class Lab1 {
    public static void main(String[] args) {
        //Aktivasi scanner agar bisa meminta input dari user
        try (
        Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan jumlah mata kuliah: ");
            int jumlahMatkul=input.nextInt(); //Meminta input jumlah mata kuliah dari user
            //memvalidasi input menggunakan while loop, meminta kembali input jika berjumlah negatif
            while (jumlahMatkul<=0){
                System.out.println("Jumlah mata kuliah yang diambil tidak dapat negatif, silahkan isi kembali");
                System.out.print("Masukkan jumlah mata kuliah: ");
                jumlahMatkul = input.nextInt();
            }

            //default value 
            int count = 1;
            double jumlahSksTotal = 0;
            double jumlahSksLulus = 0;
            double jumlahMutu = 0;
            double jumlahMutuLulus = 0;

            //Mengiterasi pertanyaan sebanyak jumlah mata kuliah yang diinput user
            for (; jumlahMatkul!=0;jumlahMatkul--){
                System.out.printf("Masukkan nama mata kuliah ke- " + count + ": ");
                count++;
                
                String namaMatkul = input.nextLine(); //meminta input nama matkul
                input.nextLine();

                System.out.print("Masukkan jumlah sks: ");
                int jumlahSks = input.nextInt(); //meminta input jumlah sks
                //memvalidasi input jumlah sks dan meminta input kembali jika berjumlah negatif
                while (jumlahSks<=0){
                    System.out.println("Jumlah SKS mata kuliah yang diambil tidak dapat negatif atau 0, silahkan isi kembali");
                    System.out.print("Masukkan jumlah sks: ");
                    jumlahSks = input.nextInt();
                }
                jumlahSksTotal = jumlahSksTotal + jumlahSks; //menambahkan jumlah sks ke jumlah sks total

                System.out.print("Masukkan nilai: ");
                double nilai = input.nextDouble(); //meminta input jumlah nilai
                // memvalidasi input dan meminta input kembali jika angka dari nilainya tidak sesuai
                while (nilai<= 0 || nilai > 100){
                    System.out.println("Nilai mata kuliah tidak valid, silahkan isi kembali");
                    System.out.print("Masukkan nilai: ");
                    nilai = input.nextDouble();
                }
                //default value
                String nilaiAkhir = "";
                double bobot = 0;
                String status = "";

                //Menggunakan if loop untuk memnentukan nilai akhir, bobot, dan juga lulus atau tidaknya
                if (nilai >= 85){
                    nilaiAkhir = "A";
                    bobot = 4;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>=80 && nilai<85){
                    nilaiAkhir = "A-";
                    bobot = 3.7;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>= 75 && nilai<80){
                    nilaiAkhir = "B+";
                    bobot = 3.3;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>=70 && nilai<75){
                    nilaiAkhir = "B";
                    bobot = 3.0;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>=65 && nilai<70){
                    nilaiAkhir = "B-";
                    bobot = 2.7;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>=60 && nilai < 65){
                    nilaiAkhir = "C+";
                    bobot = 2.3;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>=55 && nilai < 60){
                    nilaiAkhir = "C";
                    bobot = 2.0;
                    jumlahSksLulus = jumlahSksLulus + jumlahSks;
                    status = "Lulus";
                } else if (nilai>=40 && nilai <55){
                    nilaiAkhir = "D";
                    bobot = 1.0;
                    status = "Tidak Lulus";
                } else if (nilai<40){
                    nilaiAkhir = "E";
                    bobot = 0;
                    status = "Tidak Lulus";
                }

                double mutu = jumlahSks * bobot; //menghitung mutu
                jumlahMutu = jumlahMutu + mutu; //menambahkan mutu ke jumlah mutu total
                // jika lulus, maka menambah jumlah mutu lulus
                if (status == "Lulus"){
                    jumlahMutuLulus = jumlahMutuLulus + mutu;
                }
                //memformat mutu, dan mencetak ringkasan
                String formattedMutu = String.format("%.2f", mutu);
                System.out.println("Nilai huruf mata kuliah " + namaMatkul+ " adalah " + nilaiAkhir + " dengan mutu " + formattedMutu);
                System.out.println();
            }        
            // menghitung ip semester dan ip kulmulatif
            double ipSemester = jumlahMutu/jumlahSksTotal;
            // memvalidasi IPK untuk NaN
            double ipKulmulatif;
            if (jumlahSksLulus!=0){
                ipKulmulatif = jumlahMutuLulus/jumlahSksLulus;
            } else {
                ipKulmulatif = 0.00;
            }

            //memformat semua angka agar menampilkan dua angka dibelakang koma
            String formattedIPS = String.format("%.2f", ipSemester);
            String formattedIPK = String.format("%.2f", ipKulmulatif);
            String formattedSKS = String.format("%.2f", jumlahSksTotal);
            String formattedJumlahMutu = String.format("%.2f", jumlahMutu);
            String formattedMutuLulus = String.format("%.2f", jumlahMutuLulus);
            String formattedSKSLulus = String.format("%.2f", jumlahSksLulus);


            //Mencetak keseluruhan ringkasan
            System.out.println("Jumlah mutu: " + formattedJumlahMutu);
            System.out.println("Jumlah sks diambil: " + formattedSKS);
            System.out.println("IP Semester: " + formattedIPS);
            System.out.println("Jumlah mutu lulus: " + formattedMutuLulus);
            System.out.println("Jumlah sks lulus: " + formattedSKSLulus);
            System.out.println("IP Kulmulatif: " + formattedIPK);
        }
    }
}