import java.io.*;
import java.util.StringTokenizer;

/**
 * DekDepeNG
 */
public class DekDepeNG {

    private static InputReader in = new InputReader(System.in);
    private static OutputStream outputStream = System.out;
    private static PrintWriter out = new PrintWriter(outputStream); 
    private static Dosen[] listDosen;
    private static Siswa[] listSiswa;
    private static MataKuliah[] listMataKuliah;

    public static void main(String[] args) {
        int jumlahDosen = in.nextInt();
        listDosen = new Dosen[jumlahDosen];
        listMataKuliah = new MataKuliah[jumlahDosen];
        for (int i = 0; i < jumlahDosen; i++){
            String idDosen = in.next();
            String kodeMatkul = in.next();
            int kapasitas = in.nextInt();
            //Inisiasi object MatKuliah dan Dosen untuk setiap input
            MataKuliah mataKuliah = new MataKuliah(kodeMatkul, kapasitas);
            listMataKuliah[i] = mataKuliah;
            listDosen[i] = new Dosen(idDosen, mataKuliah);
        }
        
        int jumlahSiswa = in.nextInt();
        listSiswa = new Siswa[jumlahSiswa];
        for (int i = 0; i < jumlahSiswa; i++){
            String npm = in.next();
            // Inisiasi object Siswa
            listSiswa[i] = new Siswa(npm);
        }
        // meminta untuk method yang ingin digunakan dan parameternya
        int jumlahPerintah = in.nextInt();
        for(int i = 0; i < jumlahPerintah; i++){
            String perintah = in.next();
            switch (perintah) {
                case "BERINILAI": {
                    String idDosen = in.next();
                    String npm = in.next();
                    int nilai = in.nextInt();
                    //Memanggil fungsi untuk memberi nilai
                    beriNilai(idDosen, npm, nilai);
                    break;
                }
                case "CEKNILAI": {
                    String npm = in.next();
                    //Memanggil fungsi untuk mengecek nilai
                    cekNilai(npm);
                    break;
                }
                case "AMBILMATKUL": {
                    String npm = in.next();
                    String kodeMatkul = in.next();
                    //Mengiterasi list matakuliah
                    for (int k= 0; k<jumlahDosen;k++){
                        // jika mata kuliah sesuai dengan matkul yang ingin diambil
                        if (listMataKuliah[k].getKodeMatkul().equals(kodeMatkul)){
                            for (int j = 0; j< jumlahSiswa;j++){
                                //jika mahasiswa sesuai dengan mahasiswa yang ingin mengambil
                                if(listSiswa[j].getNpm().equals(npm)){
                                    //memanggil metode ambilmatkul di kelas siswa
                                    String output = listSiswa[j].ambilMatkul(listMataKuliah[k]);
                                    out.println(output);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        out.close();
    }
    // membuat method untuk memanggil fungsi beriNilai pada class Dosen
    public static void beriNilai(String idDosen, String npm, int nilai) {
        int jumlahDosen = listDosen.length;
        boolean adaDosen = false;
        // mengiterasi list dosen dan mencari dosen yang sesuai
        for (int j=0; j< jumlahDosen; j++){
            if (listDosen[j].getIdDosen().equals(idDosen)){
                adaDosen = true;
                //memanggil metode beriNilai pada kelas dosen dan mencetaknya
                String output = listDosen[j].beriNilai(npm, nilai);
                out.println(output);
                break;
            }
        }
        if (adaDosen == false){
            out.println("Dosen dengan ID " + idDosen + " tidak ditemukan");
        }    
    
    }
    //memanggil metode tampilkan nilai pada kelas siswa
    public static void cekNilai(String npm) {
        Siswa siswa = null;
        int jumlahSiswa = listSiswa.length;
        //mengiterasi list siswa untuk mencari siswa yang sesuai npm yang diinginkan
        for (int j=0; j<jumlahSiswa; j++){
            if (listSiswa[j].getNpm().equals(npm)){
                siswa = listSiswa[j];
            }
        }
        //menampilkan nilai dari siswa dengan memanggil metode dari kelas siswa
        out.println(siswa.tampilkanNilai());
    }

    
    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    // please use these classes to avoid your fast algorithm gets Time Limit Exceeded caused by slow input-output (IO)
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}