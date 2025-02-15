public class Dosen {
    private String idDosen;
    private MataKuliah mataKuliah;

    public Dosen(String idDosen, MataKuliah mataKuliah) {
        this.idDosen = idDosen;
        this.mataKuliah = mataKuliah;
    }

    //Method untuk memberi nilai kepada mahasiswa
    public String beriNilai(String npm, int nilai) {
        String output = "";
        // Implementasi logic untuk memberi nilai
        boolean mengambilMataKuliah = false;
        Siswa[] listSiswa = mataKuliah.getListSiswa(); //mendapatkan list siswa yang mengambil matkul
        for (int i = 0; i<mataKuliah.getJumlahSiswa(); ++i) {
            //mengecheck untuk mahasiswa yang sesuai dengan yang dimau berdasarkan npm
            if(listSiswa[i].getNpm().equals(npm)){;
                //menyetel nilai untuk mahasiswa yang ditemukan
                mataKuliah.getListSiswa()[i].getListNilai()[i].setNilai(nilai);
                mengambilMataKuliah = true;
            }
        }
        //outputnya jika mahasiswa mengambil matkul ini
        if (mengambilMataKuliah == true) {
            output = this.idDosen + " berhasil memberikan nilai kepada siswa dengan NPM " + npm;
        } else {// output jika mahasiswa tidak mengambil matkul ini
            output = this.idDosen + " gagal memberikan nilai kepada siswa dengan NPM " + npm;
        }
        return output; //return outputnya

    }

    public String getIdDosen() {
        return idDosen;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }
}
