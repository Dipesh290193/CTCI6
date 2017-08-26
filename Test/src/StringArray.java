
public class StringArray {

	public static void main(String args[])
	{
		String name="Dipesh k.patel s";
		String[] names= name.split(" ");
		String firstName="";
		String lastName ="";
		boolean flag=false;
		if(names.length>=2)
		{
				firstName=names[0];
				for(int i=1;i<names.length;i++)
				{
					lastName+=" "+names[i];
				}
			if(firstName.trim().length()>2 && lastName.trim().length()>2)
			{
				lastName=lastName.trim();
				flag=true;
			}
		}
		System.out.println(firstName);
		System.out.println(lastName.trim());
		System.out.println(name);
	}
}
