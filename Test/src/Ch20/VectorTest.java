package Ch20;
import java.util.*;

public class VectorTest {

	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Vector<Integer> vector=new Vector<>();
		vector.addElement(23);
		vector.addElement(25);
		vector.addElement(29);
		vector.addElement(10);
		System.out.println(vector);
		System.out.println(vector.capacity());
		vector.removeElement(10);
		vector.trimToSize();
		System.out.println(vector);
		System.out.println(vector.capacity());
		Vector<Integer> vector2=(Vector<Integer>) vector.clone();
		vector2.addAll(vector);
		System.out.println(vector2);
		List<Integer> list=Arrays.asList(1,2,3);
		Vector<Integer> v=new Vector<Integer>(list);
		System.out.println(v);
		
		ArrayList<String> a=new ArrayList<>();
		a.add("Dsp");
		a.add("Dipesh");
		Vector<String> v2=new Vector<String>(a);
		System.out.println(v2);
	}
}
