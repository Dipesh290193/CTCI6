package InstanceInitializer;

public class B extends A {

    public B(){
        System.out.println("Static instance Initilizer  class B");
    }

    public void method(){
        class Inner{
            public void print(){
                System.out.println("B Innner Print");
            }
            public void printNew(){
                System.out.println("B Inner printNew");
            }
        }
        Inner i =  new Inner();
        i.print();
        i.printNew();
    }
}
