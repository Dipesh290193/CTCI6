package Ch20;
import java.util.*;
public class StackTest {
	
	public static void main(String args[])	
	{
		Stack<Integer> stack= new Stack<>();
		stack.push(12);
		stack.add(10);
		stack.add(5);
		stack.add(2);
		stack.add(25);
		System.out.println(stack);
		System.out.println(stack.isEmpty());
		System.out.println(stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println("size= "+stack.size());
		System.out.println("Element at 2nd position= "+stack.elementAt(2));
	}
}
