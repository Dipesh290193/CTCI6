package Ch20;

import java.util.ArrayList;
import java.util.Collections;


public class B1Test {

	public static void main(String args[])
	{
		ArrayList<B1> list= new ArrayList<>();
		list.add(new B1(10));
		list.add(new B1(5));
		for (B1 b1 : list) {
			System.out.println(b1.getNum());
		}
		Collections.sort(list,new B());
		for (B1 b1 : list) {
			System.out.println(b1.getNum());
		}
	}
}
