public class Siswa {
    private String npm;
    private NilaiController[] listNilai = new NilaiController[100];

    public Siswa(String npm) {
        this.npm = npm;
    }

    public String ambilMatkul(MataKuliah mataKuliah) {
        String output = "";
        //Implementasi logic untuk mengambil mata kuliah
        int jumlashSiswa = mataKuliah.getJumlahSiswa(); // mengambil jumlah mahasiswa menggunakan getter 
        int kapasitas = mataKuliah.getKapasitas(); // mengambil kapasitas mahasiswa
        //mengecheck apakah kapasitas tersedia
        if(jumlashSiswa >= kapasitas){
            //jika kapasitas tidak tersedia maka akan gagal
            output = "Siswa dengan NPM " + npm + " gagal mengambil matkul dengan kode " + mataKuliah.getKodeMatkul();
        }else{
            //jika kapasistas tersedia
            for (int i = 0; i < listNilai.length; i++) {
                //membuat object NilaiController dan menyetel default nilainya 
                if (listNilai[i] == null) {
                    listNilai[i] = new NilaiController(mataKuliah.getKodeMatkul());
                    listNilai[i].setNilai(0);
                    break;
                }
            }
            // Menambahkan siswa ke dalam array list siswa pada objek mataKuliah
            mataKuliah.getListSiswa()[jumlashSiswa] = this;
            // Menambah jumlah siswa pada objek mataKuliah
            mataKuliah.setJumlahSiswa(jumlashSiswa + 1);
            // Menyetel outputnya
            output = "Siswa dengan NPM " + npm + " berhasil mengambil matkul dengan kode " + mataKuliah.getKodeMatkul();
        }
        return output;        
    }

    public String tampilkanNilai() {
        String output = "";
        // Implementasi logic untuk menampilkan nilai semua mata kuliah yang diambil siswa
        int jumlahMatkulDiambil = 0;
        //mengiterasi list nilai dan menampilkan informasinya 
        for (int j=0; j<listNilai.length; j++){
            if (listNilai[j] != null) {
                // Menambahkan informasi nilai mata kuliah ke dalam output
                output += "Kode matkul " +listNilai[j].getKodeMatkul() + " memiliki nilai " + listNilai[j].getNilai();
                output += "\n";
                jumlahMatkulDiambil++; //menambah jumlah matkul yang diambil 
            }
        }
        //jika tidak mengambil matkul apapun
        if (jumlahMatkulDiambil == 0) {
            output = "Siswa belum mengambil mata kuliah :v";
        }
        return output;
    }

    public NilaiController[] getListNilai() {
        return listNilai;
    }

    public String getNpm() {
        return npm;
    }
}
