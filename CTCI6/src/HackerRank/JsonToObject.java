package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToObject {

	public static void main(String[] args) throws MalformedURLException, IOException {
		InputStream input = new URL("http://restcountries.eu/rest/v1/name/eu").openStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		String jsonText = readAll(bf);
		JSONArray json  = new JSONArray(jsonText);
		for(int i = 0 ; i < json.length(); i++)
		{
			JSONObject o = json.getJSONObject(i);
			System.out.println(o.get("population"));
		}
		
	}
	
	 public static String readAll(Reader rd) throws IOException 
	 {
		 StringBuilder sb = new StringBuilder();
		 int cp;
		 while ((cp = rd.read()) != -1) 
		 {
			 sb.append((char) cp);
		 }
		 return sb.toString();
	 }
}


class Country{
	private String name;
	private String capital;
	private String relevance;
	private String region;
	private String subregion;
	private int population;
	private String demonym;
	
	public Country(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRelevance() {
		return relevance;
	}

	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}
}
