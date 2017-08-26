package AccessbilityClass;

public class TestStaticFinalField {

	

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StaticFinalField sff = new StaticFinalField();
		sff.MONTHS[1] = 10;
		
		// Will throw java.lang.UnsupportedOperationException exception 
		sff.NUM.set(1, 120);
		System.out.println(sff.MONTHS[1]);
		System.out.println(sff.NUM.get(1));
	}
}
