import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Expression1 {

	private static Map<Character, Integer> op;

	public static void main(String args[]) throws Exception {
		op = new HashMap<>();
		op.put('/', 4);
		op.put('*', 3);
		op.put('+', 2);
		op.put('-', 1);
		String str = "11*22/(6/3*2/2-3+3)+667-(123+2*2)";
		System.out.println(calculate(str));
	}

	public static int calculate(String ex) throws Exception {
		try {
			ex = ex.trim();
			if (ex == "" || ex.equals("") || ex == null || ex.equals(null)) 
			{
				return -1;
			}

			// store operands of the expression
			ArrayList<Integer> operands = new ArrayList<>();
			// store operators of the expression
			ArrayList<Character> operators = new ArrayList<>();
			
			String ch = "";

			for (int i = 0; i < ex.length(); i++)
			{
				if (ex.charAt(i) == 40)
				{
					i++;
					String str = "";
					while (ex.charAt(i) != 41) 
					{
						str += Character.valueOf(ex.charAt(i));
						i++;
					}
					if(i==ex.length()-1)
					{
						operands.add(calculate(str));
					}
					else
					{
						ch=Integer.toString(calculate(str));
					}
				}
				// if character is any operator then any number which is not
				// empty and before the operator should
				// add to operators stack
				else if (ex.charAt(i) == 42 || ex.charAt(i) == 43 || ex.charAt(i) == 45 || ex.charAt(i) == 47) 
				{
					// ch is empty when two operators are together which means
					// expression is not correct
					if (ch.equals("")) 
					{
						System.out.println("Invalid input");
						// throw new Exception("Invalid input");
					} else 
					{
						operands.add(Integer.parseInt(ch.trim()));
						ch = "";
					}
					operators.add(Character.valueOf(ex.charAt(i)));
				}
				// get the number before any operator and combine it
				else if (ex.charAt(i) >= 48 && ex.charAt(i) <= 57)
				{
					// if i=0 means their is no operator after the number
					if (i == ex.length() - 1)
					{
						ch += Character.toString(ex.charAt(i));
						operands.add(Integer.parseInt(ch.trim()));
						ch = "";
					}

					ch += Character.toString(ex.charAt(i));
				} 
				else 
				{
					System.out.println("Invalid Expression");
					return -1;
				}
			}

			return eval(operands, operators);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Invalid expression");
		} catch (ArithmeticException e) {
			throw new Exception("Invalid input Arithmetic Exception");
		} catch (NumberFormatException e) {
			throw new Exception("Invalid input");
		}
	}

	public static int eval(ArrayList<Integer> operands, ArrayList<Character> operators)
	{
		while (operands.size() > 1 && operators.size() > 0)
		{
			System.out.println("operands=" + operands.toString());
			System.out.println("operators=" + operators.toString());
			System.out.println("operands size=" + operands.size());
			System.out.println("opearator size=" + operators.size());
			int index = 0;
			int precedence = 0;

			for (int i = 0; i < operators.size(); i++) 
			{
				if (op.get(operators.get(i)) > precedence) {
					precedence = op.get(operators.get(i));
					index = i;
				}
			}
			if (precedence > 0) 
			{
				char ch = operators.get(index);
				if (ch == '/') {
					operands.set(index, operands.get(index) / operands.get(index + 1));
					operands.remove(index + 1);
					operators.remove(index);
				} else if (ch == '*') {
					operands.set(index, operands.get(index) * operands.get(index + 1));
					operands.remove(index + 1);
					operators.remove(index);
				} else if (ch == '+') {
					operands.set(index, operands.get(index) + operands.get(index + 1));
					operands.remove(index + 1);
					operators.remove(index);
				} else if (ch == '-') {
					operands.set(index, operands.get(index) - operands.get(index + 1));
					operands.remove(index + 1);
					operators.remove(index);
				}
			}
		}
		return operands.get(0);
	}

}
