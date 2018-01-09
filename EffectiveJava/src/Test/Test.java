package Test;

public class Test {
    private int id =10;
    private static final Test test = new Test();

    private Test(){

    }
    public static Test getInstance(){
        return test;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
       this.id = id;
    }
}
