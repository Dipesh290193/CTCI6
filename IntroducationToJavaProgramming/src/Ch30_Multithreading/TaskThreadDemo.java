package src.Ch30_Multithreading;

public class TaskThreadDemo {

	public static void main(String args[])
	{
		Runnable printA=new PrintChar('a', 10000);
		Runnable printB=new PrintChar('b', 10000);
		Runnable printNum=new PrintNum(10000);
		
		Thread thread1=new Thread(printA);
		Thread thread2=new Thread(printB);
		Thread thread3=new Thread(printNum);
		
		thread1.start();
		//IllegalThreadStateException
		//thread1.start();
		thread2.start();
		thread3.start();
	}
}

class PrintChar implements Runnable
{
	char ch;
	int times;
	
	PrintChar(char ch, int times)
	{
		this.ch=ch;
		this.times=times;
	}

	@Override
	public void run() {
		for(int i=0;i<this.times;i++)
		{
			System.out.print(this.ch);
		}
		
	}
}

class PrintNum implements Runnable
{
	int times;
	
	PrintNum(int times)
	{
		this.times=times;
	}

	@Override
	public void run() {
		for(int i=0;i<this.times;i++)
		{
			System.out.print(i);
		}
		
	}
}
