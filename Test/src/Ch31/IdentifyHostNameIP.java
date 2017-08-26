package Ch31;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IdentifyHostNameIP {

	public static void main(String args[]) throws UnknownHostException
	{
		InetAddress address=InetAddress.getByName("www.google.com");
		InetAddress add=InetAddress.getByName("csns.calstatela.edu");
		InetAddress ad=InetAddress.getByName("cs3.calstatela.edu");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println(add.getHostName());
		System.out.println(add.getHostAddress());
		System.out.println(ad.getHostName());
		System.out.println(ad.getHostAddress());
	}
}
