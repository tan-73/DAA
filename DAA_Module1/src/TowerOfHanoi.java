import java.util.Scanner;

public class TowerOfHanoi {
	public static void tower (int n, char source, char auxillary, char destination) {
		if (n == 1) { 
			System.out.println("Move disk from "+source+" to "+destination);
			return;
		}
		
		tower(n-1, source, destination, auxillary);
		System.out.println("Move disk from "+source+" to "+destination);
		tower(n-1, auxillary, source, destination);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter number of disks : ");
		int n = sc.nextInt();
		
		tower(n, 'A', 'C', 'B');
	}
}
