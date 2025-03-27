import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class BubbleSort {
    public static void sort(int[] arr) {
        int i, j, temp;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
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
		sort(arr);
		long estimatedTime = System.nanoTime() - startTime;
		
		PrintWriter outA = new PrintWriter(new File("SortedNos.txt"));
		
		for (int i = 0 ; i < n ; i++) {
			outA.print(arr[i]);
			outA.print("\n");
		}
		outA.close();
		
		System.out.println("The estimated time to sort is : "+estimatedTime/1000000000.00);
    }
}
