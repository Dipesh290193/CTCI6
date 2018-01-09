package InstanceInitializer;

public class A {
    public A()
    {
        System.out.println("Constructor instance Initilizer class A");
    }
    {
        System.out.println("instance Initilizer");
    }
    static {
        System.out.println("Static instance Initilizer");
    }

    class Inner{
        public void print(){
            System.out.println("Inner Class");
        }
    }
}
