import java.util.Scanner;

public class BinarySearch {
	public static int search(int[] arr, int low, int high, int key) {
		
		if (high >= low) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key)
				return search(arr, low, mid-1, key);
			else
				return search(arr, mid+1, high, key);
		}
		return -1;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter number of elements : ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.print("Enter the elements : ");
		for (int i = 0 ; i < n ; i++)
			arr[i] = sc.nextInt();
		
		System.out.print("Enter the key element : ");
		int key = sc.nextInt();
		int result = search(arr, 0, n-1, key);
		
		if (result == -1) 
			System.out.println("Element not found");
		else
			System.out.println("Element found at position "+(result+1));
		
	}
} 