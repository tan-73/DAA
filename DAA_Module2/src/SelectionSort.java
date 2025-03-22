import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class SelectionSort {
	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter the number of elements to sort : ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		PrintWriter out = new PrintWriter(new File("RandomNos.txt"));
		Random rand = new Random();
		
		for (int i = 0 ; i < n ; i++) {
			arr[i] = rand.nextInt(n);
		
			out.print(arr[i]);
			out.print(" ");
		}
		out.close();
		long startTime = System .nanoTime();
		selectSort(arr);
		long estimatedTime = System.nanoTime() - startTime;
		PrintWriter outA = new PrintWriter(new File("SortedNos.txt"));
		
		for (int i = 0 ; i < n ; i++) {
			outA.print(arr[i]);
			outA.print(" ");
		}
		outA.close();
		System.out.println("The estimated time for executing is : "+estimatedTime/1000000000.00);
	}
	
	public static void selectSort(int[] arr) {
		int i, j, min;
		for (i = 0 ; i < arr.length ; i++) {
			min = i;
			for (j = i+1 ; j < arr.length ; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}
	
	public static void swap (int[] arr, int i, int j) {
		arr[i] += arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] -= arr[j];
	}
}