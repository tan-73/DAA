import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements to sort: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // File file = new File("RandomNos.txt");
        PrintWriter out = new PrintWriter(new File("RandomNos.txt"));
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt();
            out.println(arr[i]);
        }
        out.close();

        long startTime = System.nanoTime();
        sort(arr);
        long estimatedTime = System.nanoTime() - startTime;

        // File sortedFile = new File("SortedNos.txt");
        PrintWriter outA = new PrintWriter(new File("SortedNos.txt"));

        for (int i = 0; i < n; i++) {
            outA.println(arr[i]);
        }
        outA.close();

        System.out.println("The estimated time to sort is: " + estimatedTime / 1_000_000_000.00 + " seconds");
        sc.close();
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
