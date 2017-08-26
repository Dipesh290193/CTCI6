
public class FindTimeComplexity {

	public static void main(String[] args) {
		
	int count = 0;
	for (int i = 100; i > 0; i /= 2) {
	   for (int j = 0; j < i; j++) {
	       count += 1;
	     }
	  }
	System.out.println(count);

	}
}
