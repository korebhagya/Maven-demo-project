package practice;

public class GenericMethodPractice {
	
	// test script

	public static void main(String[] args) { // caller function
		add(10,20);
		add(20,40);
		add(30,50);
		
		

	}
	public static void add(int a, int b) // called function-generic method
	{
		int c = a+b;
		System.out.println(c);
	}

}
