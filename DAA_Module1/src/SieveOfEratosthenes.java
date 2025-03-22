import java.lang.Math;
import java.util.Scanner;


public class SieveOfEratosthenes {
	public static void sieve (int n) {
		boolean prime[] = new boolean [n + 1];
		for (int i = 0 ; i <= n ; i++) 
			prime[i] = true;
		
		for (int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if (prime[i] == true) {
				for (int j = i * i ; j <= n ; j += i) {
					prime[j] = false;
				}
			}
		}
		for (int i = 2 ; i <= n ; i++) {
			if (prime[i] == true) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter a number : ");
		int n = sc.nextInt();
		System.out.println("Prime numbers from 2 to "+n+" are : ");
		sieve(n);
	}
}
