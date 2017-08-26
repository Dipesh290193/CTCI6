package MethodClone;

public class TestClone {

	public static void main(String args[]){
		Stack s = new Stack();
		s.push("obj1");
		s.push("obj2");
		
		Stack st = s.clone();
		st.push("obj3");
		st.push("objjjj");
		s.push("obj4");
		System.out.println(s.pop());
		System.out.println(st.pop());
		System.out.println(s.pop());
		System.out.println(st.pop());
	}
}
