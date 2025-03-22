import java.util.Scanner;

public class GCD {
	public static int calculate (int num1, int num2) {
		if (num2 == 0) 
			return num1;
		else
			return calculate(num2, num1 % num2);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter 2 numbers : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.print("GCD : "+calculate(num1, num2));
	}
} 