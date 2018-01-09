package Test;

public class TestMapSum {
    public  static  void main(String args[]){
        MapSum obj = new MapSum();
        obj.insert("apple",3);
        System.out.println(obj.sum("ap"));
        obj.insert("app",2);
        System.out.println(obj.sum("ap"));
    }
}
