package ch7_ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {

}

class CallHandler{
	private static List<Employee> resonders = new ArrayList<Employee>();
	private static List<Employee> managers = new ArrayList<>();
	private static List<Employee> directors  = new ArrayList<>();
	
	List<List<Call>> queue;
	
	public Employee assignEmployee(Call call)
	{
		return null;
	}
	
	public void addEmployee(Employee e)
	{
		
	}
	
	
	
	
}
 enum Position 
{
	RESPONDER, MANAGER, DIRECTOR
}
class Caller{
	String name;
	int ssn;
	String area;
	public Caller(String name, int ssn)
	{
		this.name = name;
		this.ssn = ssn;
	}
}
class Call{
	
	private Caller caller;
	private Employee callHandler;
	
	public Call(Caller c)
	{
		this.caller = c;
	}
	
	public void replay(String message){}
	public void setCallHandler(Employee e)
	{
		this.callHandler = e;
	}
	
	public Employee getCallHandler()
	{
		return this.callHandler;
	}
	
	public void disconnect(){
		
	}
	
}
abstract class Employee{
	
	private Call currentCall;
	private String empId;
	private String name;
	protected Position position;
	
	public boolean isFree()
	{
		return currentCall == null;
	}
	
	public void receiveCall(Call call)
	{
		this.currentCall = call;
	}
	
	public void finishCall()
	{
		this.currentCall = null;
	}
	
	
}

class Responder extends Employee
{
	public Responder(){
		this.position = Position.RESPONDER;
	}
}

class Manager extends Employee
{
	public Manager(){
		this.position = Position.MANAGER;
	}
}

class Director extends Employee
{
	public Director(){
		this.position = Position.DIRECTOR;
	}
}
