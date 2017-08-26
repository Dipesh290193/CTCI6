
public class Solution {

	public static void main(String args[])
	{
		int[] arr={5,5,1,7,2,3,5};
		System.out.println(solution(5, arr));
	}

	public static int solution(int X, int[] A) {
        
		int len=A.length-1;
		int count=0;
        for(int i=0, j=len;i<j;)
        {
        	if(X==A[i])
        	{
        		i++;
        		count++;
        		if(X==A[j])
        		{
        			count++;      			
        		}
        		else
        		{
        			j--;
        		}
        	}
        	else
        	{
        		if(X==A[j])
        		{
        			count++;
        			A[j]=A[i];
        			A[i]=X;
        			
        		}
        		i++;
    			j--;
        		
        	}
        }
        return count+1;
    }
	public static int sol(int X, int[] A)
	{
		int n=0;
		int m=A.length-1;
		int k=-1;
		boolean sw=false;
		int x_count=0;
		int non_x_count=0;
		do{
			if(!sw)
			{
				if(A[n]==X)
				{
					x_count++;
					sw=true;
				}
				n++;
			}
			else
			{
				if(A[m]!=X)
				{
					non_x_count++;
					sw=false;
				}
				m--;
			}
		}while(m-n>-1);
		if(non_x_count==x_count)
			k=n;
		return k;
	}
}
