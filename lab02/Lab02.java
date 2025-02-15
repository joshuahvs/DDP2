import java.util.Scanner;

public class Lab02 {
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

    public static String decode(String inputString) {
        String toReverse = reverseString(inputString);
        String toDecode = wrapString(toReverse);
        String decoded = decoding(toDecode, "",0,0);
        return reverseString(decoded).toString();
    }

    public static String reverseString(String str) {
        String reversedString = "";
        for(int i = str.length()-1; i>=0; i--){
            reversedString += str.charAt(i);
        }
        return reversedString;
    }

    public static String wrapString(String inputString){
        String  outputString= "L" + inputString + "R";
        return outputString;
    }

    public static String decoding(String toDecode, String currentTranslation, int currentDecimal, int currentExponent){
        if(toDecode.isEmpty()){
            return currentTranslation;
        }
        char currentChar = toDecode.charAt(0);
        if (Character.isDigit(currentChar)){
            int digit = Character.getNumericValue(currentChar);
            currentDecimal += digit*Math.pow(2, currentExponent);
            return decoding(toDecode.substring(1), currentTranslation, currentDecimal, currentExponent+1);
        } else{
            char translatedChar = (char) currentDecimal;
            String translating = currentTranslation + translatedChar;
            return decoding(toDecode.substring(1),translating,0,0);
        }
    }
}
