package Test;

public class TestConstructor {

    public static void main(String args[]){
        Test t =Test.getInstance();
        System.out.println(t.getId());

        Test t1 = Test.getInstance();

        t.setId(15);
        System.out.println(t1.getId());
    }
}
