public class Main {
    public static void main(String[] args) {
        // String message = "welcome to java";
        // System.out.println(message.substring(0,5));
        byte b = (byte) 10000;
        System.out.println(b);
    }
}

class P{
    int a = 10;

    public P(){
        test(5);
    }
    public void test(int x){
        a=10*x;
        System.out.println(a + " ");
    }
    private void test2(int x){
        System.out.println(3*x);
    }
    public static void main(String[] args) {
        P obj = new Q();
        obj.test(3);
        obj.test2(3);
    }
}

class Q extends P{
    int a = 20;

    public Q(){

    }
    public void test(int x){
        a = 20*x;
        System.out.println(a + " ");
    }

    private void test2(int x){
        System.out.println(2*x);
    }
}
