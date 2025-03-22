import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class QuickSort {
	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter the number of elements to sort : ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		PrintWriter out = new PrintWriter(new File("RandomNos.txt"));
		Random rand = new Random();
		
		for (int i = 0 ; i < n ; i++) { 
			arr[i] = rand.nextInt();
			out.print(arr[i]);
			out.print("\n");
		}
		out.close();
		
		long startTime = System.nanoTime();
		sort(arr, 0, arr.length-1);
		long estimatedTime = System.nanoTime() - startTime;
		
		PrintWriter outA = new PrintWriter(new File("SortedNos.txt"));
		
		for (int i = 0 ; i < n ; i++) {
			outA.print(arr[i]);
			outA.print("\n");
		}
		outA.close();
		
		System.out.println("The estimated time to sort is : "+estimatedTime/1000000000.00);
		
	}
	
	public static void sort (int[] arr, int beg, int end) {
		if (beg < end) {
			int pi = partition(arr, beg, end);
			sort(arr, beg, pi - 1);
			sort(arr, pi + 1, end);
		}
	}
	
	public static int partition (int[] arr, int beg, int end) {
		int pivot = arr[end];
		int i = beg - 1;
		
		for (int j = beg ; j < end ; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, end);
		return i+1;
	}
	
	public static void swap (int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
}
	
