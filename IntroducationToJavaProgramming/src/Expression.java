package src;

import java.util.Stack;


public class Expression {

	
	
	public static void main(String args[]) throws Exception {

		System.out.println(calculate("2*6/3+66"));
	}

	public static float calculate(String ex) throws Exception 
	{
		try
		{
		float result=0;
		ex = ex.trim();
		//store operands of the expression
		Stack<Integer> operands = new Stack<>();
		//store operators of the expression
		Stack<Character> operators = new Stack<>();
		String ch="";
		 
		for (int i = ex.length()-1; i >=0;i--) 
		{
			//if character is any operator then any number which is not empty and before the operator should 
			//add to operators stack
			if(ex.charAt(i)==42 || ex.charAt(i)==43 || ex.charAt(i)==45 || ex.charAt(i)==47)
			{
				//ch is empty when two operators are together which means expression is not correct
				if(ch.equals(""))
				{
					throw new Exception("Invalid input");
				}
				else
				{
					operands.push( Integer.parseInt(ch.trim()));
					ch="";
				}
				operators.push(Character.valueOf(ex.charAt(i)));
			}
			//get the number before any operator and combine it
			else
			{
				//if i=0 means their is no operator after the number
				if(i==0)
				{
					System.out.println("oprators"+operators.toString());
					System.out.println("oprands"+operands.toString());
					ch=Character.toString(ex.charAt(i))+ch;
					result=Float.parseFloat(ch);
					while(operators.size()>0)
					{
						char operator=operators.pop();
						if(operator=='+')
						{
							result+=operands.pop();
						}	
						else if(operator=='-')
						{
							result-=operands.pop();
						}	
						else if(operator=='*')
						{
							result*=operands.pop();
						}	
						else if(operator=='/')
						{
							result/=operands.pop();
						}
					}
					ch="";
				}
				ch=Character.toString(ex.charAt(i))+ch;
			}
		}
		
		
		return result;
		}catch(ArithmeticException e)
		{
			throw new Exception("Invalid input Arithmetic Exception");
		}
		catch(NumberFormatException e)
		{
			throw new Exception("Invalid input");
		}
	}
	
}
