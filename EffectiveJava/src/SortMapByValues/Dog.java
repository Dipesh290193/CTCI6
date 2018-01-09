package SortMapByValues;

public class Dog implements  Comparable<Dog> {
    int size;

    public Dog(int size){
        this.size = size;
    }
    @Override
    public int compareTo(Dog d) {
        if(this.size > d.size){
            return 1;
        }
        else if(this.size < d.size){
            return -1;
        }
        else{
            return 0;
        }
    }
}
