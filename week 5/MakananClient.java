public class MakananClient {
    public static void main(String[] args) {
        Makanan ciki = new Makanan("ciki", 120.0);
        System.out.println(ciki.jumlahKalorialori);
    }
}

class Makanan {
    protected String nama;
    public double jumlahKalorialori;

    public Makanan(String nama, double jumlahKalori){
        this.nama = nama;
        this.jumlahKalorialori = jumlahKalori;
    };

}