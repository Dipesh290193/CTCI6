package Ch10;

public class StringExample {

	public static void main(String args[])
	{
		String s1="Welcome to java";
		String s2=s1;
		String s3=new String("Welcome to java");
		String s4="Welcome to java";
		System.out.println("length= "+s3.length());
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		String s5=s1.replace("java", "HTML");
		System.out.println(s5);
		System.out.println(s1);
		System.out.println(s1.replace('o', 'T'));
		System.out.println(s1.replaceAll("o", "T"));
		System.out.println(s1.replaceFirst("o", "T"));
		System.out.println(s1.toCharArray());
	}
}
