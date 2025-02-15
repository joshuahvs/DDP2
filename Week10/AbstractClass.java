package Week10;

abstract class SimpleAbstract{
    protected int x;

    public SimpleAbstract(){
        System.out.println("Constructor Abstract");
    }

    public void concrete(){
        System.out.println("Concrete Method");
    }
    public abstract void hello(String name);
}

class Simple extends SimpleAbstract{
    public void hello(String name){
        System.out.println("Hello, "+ name);
    }
}

public class AbstractClass{
    public static void main(String[] args) {
        Simple s = new Simple();
        s.hello("Sis");
        s.concrete();
    }
}


