package AccessbilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticFinalField{

	//Never do this because MOTHS object is immuatable but Integer is mutable so any one can change the values from MONTHS.
	public static final Integer[] MONTHS = {2,5,7,9};
	
	// Fix of above problem 
	private static final Integer[] NUMS = {10,25,22};
	public static final List<Integer> NUM = Collections.unmodifiableList(Arrays.asList(NUMS));
	
	
	//--------------------------OR --------------------------------------
	
	private static final Integer[] nums = {10,25,22};
	public static final Integer[] values(){
		return nums.clone();
	}
	
	// If data type is primitive than access modifier is fine.
	public static final int num = 23;
}
