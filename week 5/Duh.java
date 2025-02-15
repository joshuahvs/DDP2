public class Duh {
    public static void main(String[] args) {
        String a = "ohhelloeveryoneinddp2";
        char[] dst = new char[10];
        a.getChars(0, 5, dst, 2);
        System.out.println(dst[5]);
    }
}
