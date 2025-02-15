import java.util.Scanner; //import scanner untuk meminta input user

public class Lab02Copy {
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
        String toDecode = wrapString(toReverse); //mewrap kode 
        String decoded = decoding(toDecode, "",0,0); //mendecode code
        return reverseString(decoded).toString();//mereverse stringnya lagi agar tidak terbalik
    }

    //method untuk mereverse / membalikan susunan dari sebuah string
    public static String reverseString(String str) {
        String reversedString = "";
        for(int i = str.length()-1; i>=0; i--){
            reversedString += str.charAt(i);
        }
        return reversedString;
    }
    //method untuk mewrap string dengan sesuatu
    public static String wrapString(String inputString){
        String  outputString= "L" + inputString + "R";
        return outputString;
    }
    //method untuk medecode code
    public static String decoding(String toDecode, String currentTranslation, int currentDecimal, int currentExponent){
        if(toDecode.isEmpty()){
            return currentTranslation;
        }
        char currentChar = toDecode.charAt(0);
        if (Character.isDigit(currentChar)){
            int digit = Character.getNumericValue(currentChar);
            if (digit == 0 || digit ==1){
                currentDecimal += digit*Math.pow(2, currentExponent);
                return decoding(toDecode.substring(1), currentTranslation, currentDecimal, currentExponent+1);
            }else{
                return decoding(toDecode.substring(1), currentTranslation, currentDecimal, currentExponent);
            }
        } else{
            char translatedChar = (char) currentDecimal;
            String translating = currentTranslation + translatedChar;
            return decoding(toDecode.substring(1),translating,0,0);
        }
    }
}
