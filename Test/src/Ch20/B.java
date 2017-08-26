package Ch20;

import java.util.*;

public class B implements Comparator<B1>{

	@Override
	public int compare(B1 o1, B1 o2) {
		if(o1.getNum() > o2.getNum())
		{
			return 1;
		}
		else if(o1.getNum()<o2.getNum())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	
}
