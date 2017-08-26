package Ch10;

public class TestImmutableExample {

	public static void main(String args[])	
	{
		ImmutableExample im=new ImmutableExample("Dipesh",1);
		System.out.println(im.getName());
		System.out.println(im.getNum());
		String name=im.getName();
		name="Patel";
		int num=im.getNum();
		num=10;
		System.out.println(im.getName());
		System.out.println(im.getNum());
		System.out.println(name);
		System.out.println(num);
	}
}
