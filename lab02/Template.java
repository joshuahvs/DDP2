import java.util.Scanner;

public class Template {
    public static void main(String[] args) {
        String inputString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan confession dalam bentuk kode (ketik 'selesai' untuk keluar):");
        while (true){
            inputString = scanner.nextLine();
            if(inputString.equals("selesai")){
                break;
            }
            String extractedString = getConfessWrapper(reverseString(inputString)); //extract binary string dari belakang
            System.out.println(extractedString);
        }
        scanner.close();
    }

    public static String reverseString(String str) {
        String reversedString = "";
        for(int i = str.length()-1; i>=0; i--){
            reversedString += str.charAt(i);
        }
        return reversedString;
        // TODO: reverse string dengan for loop atau lainnya
        
        // throw new UnsupportedOperationException("tolong implementasi method reverseString");
    }

    public static  String getConfessWrapper(String confess){
        // TODO:
        //  implementasi wrapper method untuk getConfess
        //  Hint:
        //        * Jika kamu mengikuti method getConfess di bawah,
        //        maka terdapat beberapa edge case, seperti kemungkinan bagian awal atau akhir
        //        dari string confess diisi oleh angka biner, sehingga getConfess belum sempat update translasinya.
        //        Untuk mencegah hal itu, kamu bisa modifikasi input confessnya
        //        dengan menambahkan karakter yang tidak mempunyai efek di awal dan akhir confess agar dipastikan
        //        bahwa ada update translasi ketika confess habis.
        //        * jangan lupa reverse jawaban akhir stringnya karena sebelumnya kita extract binary dari belakang.
        //
        throw new UnsupportedOperationException("tolong implementasi method getConfessWrapper");
    }


    public static String getConfess(String confess, String currentTranslation, int currentDecimal, int currentExponent){
        // TODO: implementasi recursive method getConfess.
        //  Hint:
        //        * linear recursive yang mana memakan character satu persatu.
        //        * Perbarui hasil translasi ketika current character ( confess.charAt(0) ) itu non digit
        throw new UnsupportedOperationException("tolong implementasi method getConfess");
    }

    public static String asciiToString(int asciiValue) {
        // TODO: ubah ascii ke String. Hint: ascii 0 jadi empty string
        throw new UnsupportedOperationException("tolong implementasi method asciiToString");
    }
}

/*
* Selamat Mengerjakan
* */