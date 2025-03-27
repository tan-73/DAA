import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class MergeSort {
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
			int mid = beg + (end - beg) / 2;
			
			sort(arr, beg, mid);
			sort(arr, mid+1, end);
			
			merge(arr, beg, mid, end);
		}
	}
	
	public static void merge (int[] arr, int beg, int mid, int end) {
		int n1 = mid - beg + 1;
		int n2 = end - mid;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for (int i = 0 ; i < n1 ; i++) 
			L[i] = arr[beg + i];
		for (int j = 0 ; j < n2 ; j++)
			R[j] = arr[mid + 1 + j];
		
		int i = 0, j = 0, k = beg;
		
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
