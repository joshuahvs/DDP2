import java.util.Scanner;

public class Duh {
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
        // Implementasi wrapper method untuk getConfess
        confess = "P" + confess + "P"; // Adding non-effective characters at the beginning and end
        String decoded = getConfess(confess, "", 0, 0);
        return new StringBuilder(decoded).reverse().toString(); // Reversing the decoded string
    }


    public static String getConfess(String confess, String currentTranslation, int currentDecimal, int currentExponent){
        if (confess.isEmpty()) {
            return currentTranslation;
        }

        char currentChar = confess.charAt(0);
        if (Character.isDigit(currentChar)) {
            int digit = Character.getNumericValue(currentChar);
            currentDecimal += digit * Math.pow(2, currentExponent);
            return getConfess(confess.substring(1), currentTranslation, currentDecimal, currentExponent + 1);
        } else {
            char translatedChar = (char) currentDecimal;
            String updatedTranslation = currentTranslation + translatedChar;
            return getConfess(confess.substring(1), updatedTranslation, 0, 0);
        }
    }

    // public static String asciiToString(int asciiValue) {
    //     if (asciiValue == 0) {
    //         return "";
    //     }
    //     return Character.toString((char) asciiValue);
    // }
}
