package src.Ch31;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IdentifyHostNameIP {

	public static void main(String args[]) throws UnknownHostException
	{
		InetAddress google=InetAddress.getByName("www.google.com");
		InetAddress csns=InetAddress.getByName("csns.calstatela.edu");
		InetAddress cs3=InetAddress.getByName("cs3.calstatela.edu");
		System.out.println(google.getHostAddress());
		System.out.println(google.getHostName());
		System.out.println(csns.getHostName());
		System.out.println(csns.getHostAddress());
		System.out.println(cs3.getHostName());
		System.out.println(cs3.getHostAddress());
	}
}
