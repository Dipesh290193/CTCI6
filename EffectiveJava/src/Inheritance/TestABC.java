package Inheritance;

public class TestABC {

    public static void main(String args[]){
        A a = new A();
        A a1 = new B();
        B b = new B();
        B b1 = new C();
        C c = new C();

        System.out.println(a.m());
        System.out.println(a1.m());
        System.out.println(b.m());
        System.out.println(b1.m());
        System.out.println(c.m());

        b.m2();
        b1.m2();
    }
}
