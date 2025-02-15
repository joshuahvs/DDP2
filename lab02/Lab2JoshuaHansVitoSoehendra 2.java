import java.util.Scanner; //import scanner untuk meminta input user

public class Lab2JoshuaHansVitoSoehendra {
    //main class
    public static void main(String[] args) {
        String inputString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan confession dalam bentuk kode (ketik 'selesai' untuk keluar):");
        while (true){
            inputString = scanner.nextLine();
            if(inputString.equals("selesai")){
                break;
            }
            String extractedString = decode(inputString);
            System.out.println(extractedString);
        }
        scanner.close();
    }

    //method untuk menjalankan keseluruhan proses mendecode
    public static String decode(String inputString) {
        String toReverse = reverseString(inputString); //memanggil method untuk mereverse string
        String toDecode = wrapString(toReverse); // memanggil method untuk mewrap kode 
        String decoded = decoding(toDecode, "",0,0); //memanggil method untuk mendecode code
        return reverseString(decoded).toString();//mereverse stringnya lagi agar tidak terbalik
    }

    //method untuk mereverse / membalikan susunan dari sebuah string
    public static String reverseString(String str) {
        String reversedString = "";
        //mengiterasi indexnya dari yang terbesar untuk memasukkan angka mulai dari yang paling belakang ke string kosong
        for(int i = str.length()-1; i>=0; i--){
            reversedString += str.charAt(i);
        }
        return reversedString;
    }
    //method untuk mewrap string dengan sesuatu
    public static String wrapString(String inputString){
        //menambahkan huruf ke kanan dan kiri string untuk mencegah bagian awal dan akhir diisi oleh angka biner
        String  outputString= "L" + inputString + "R";
        return outputString;
    }

    //method rekursif untuk mengubah biner menjadi kata-kata
    public static String decoding(String toDecode, String currentTranslation, int currentDecimal, int currentExponent){
        //base case jika string sudah diiterasi keseluruhan
        if(toDecode.isEmpty()){
            return currentTranslation;
        }
        char currentChar = toDecode.charAt(0); //char pertama dari string toDecode
        //mengecheck apakah stringnya merupakan digit atau tidak
        if (Character.isDigit(currentChar)){
            int digit = Character.getNumericValue(currentChar); //mengubah char menjadi int
            //mengecheck apakah digitnya 0 atau 1, jika bukan, maka akan diignore/dilompati (untuk challengenya)
            if (digit == 0 || digit ==1){
                //mengubah biner menjadi desimal
                currentDecimal += digit*Math.pow(2, currentExponent);
                //merekursi program untuk char selanjutnya, dan menambah eksponen
                return decoding(toDecode.substring(1), currentTranslation, currentDecimal, currentExponent+1);
            }else{
                return decoding(toDecode.substring(1), currentTranslation, currentDecimal, currentExponent);
            }
        } else{
            // jika bukan digit, maka akan mengubah desimal menjadi karakter, lalu mereset desimal dan ekponen untuk penghitungan selanjutnya
            char translatedChar = (char) currentDecimal;
            String translating = currentTranslation + translatedChar;
            return decoding(toDecode.substring(1),translating,0,0);
        }
    }
}
