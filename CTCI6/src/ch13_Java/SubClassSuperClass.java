package ch13_Java;

public class SubClassSuperClass {

    public static void main(String args[]){
       A a = new C();
       a.display();
    }

}

class A{
    public void display(){
        System.out.print("Display A");
    }
}

class B extends A{
    @Override
    public void display(){
        System.out.print("Display B");
    }

    public void displayB(){
        System.out.print("DisplayB()");
    }
}

class C extends A{

    @Override
    public void display(){
        System.out.print("Display C");
    }

    public void displayC(){
        System.out.print("DisplayC()");
    }
}
