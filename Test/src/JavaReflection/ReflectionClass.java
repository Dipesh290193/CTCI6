package JavaReflection;

public class ReflectionClass {

	public static enum E {abc,bcd};
	public static void main(String args[])
	{
		//we can get only reference type variables class name
		String i="abc";
		System.out.println(i.getClass());
		System.out.println(E.abc.getClass());
		
		//primitive type
		Class c=boolean.class;
		System.out.println(c.getName());
		
		Class c1=java.io.PrintStream.class;
		System.out.println(c1.getName());
		
	}
}
