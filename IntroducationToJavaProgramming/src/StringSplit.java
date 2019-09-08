package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringSplit {

	public static void main(String args[]) throws IOException {
		String line = null;
		String fileName = "starbucks.csv";
		FileReader read = new FileReader(fileName);
		BufferedReader bf = new BufferedReader(read);
		while ((line = bf.readLine()) != null) {
			String[] str = line.split(",");
			if (str.length == 5) {
				str[3] = str[3].substring(1, str[3].length()).trim();
				str[4] = str[4].substring(0, str[4].length() - 1).trim();
				String address = str[3].trim();
				String[] strCity=str[2].split(":");
				String city="";
				if(strCity.length>1)
					 city = strCity[1].trim();
				String[] strZipPhone = str[4].split(";");
				String[] strzipcode=strZipPhone[0].trim().split(" ");
				String cityPartialName=strzipcode[0].trim();
				int zipcode=0;
				if(strzipcode.length>1)
					zipcode=Integer.parseInt(strzipcode[1].trim().substring(0, 5));
				String phone="";
				if(strZipPhone.length >1)
					phone=strZipPhone[1].trim();
				System.out.println("longitude: " + str[0]);
				System.out.println("latitude: " + str[1]);
				System.out.println("Address: " + address);
				System.out.println("city: " + city);
				System.out.println("cityPartialName: "+cityPartialName);
				System.out.println("zipcode: " + zipcode);
				System.out.println("phone: "+phone);

			}
		}
		bf.close();
	}
}
