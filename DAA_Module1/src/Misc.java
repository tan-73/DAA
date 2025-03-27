import java.util.Scanner;

public class Misc {
	public static int factorial (int num) {
		// int fact;
		if (num == 1 || num == 0)
			return 1;
		return num * factorial(num - 1);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter a number : ");
		int n = sc.nextInt();
		
		System.out.println("Factorial of "+n+" is : "+factorial(n));
	}
}
