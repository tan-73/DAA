import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = findMinMax(arr);

        System.out.println("Minimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1]);

        sc.close();
    }

    public static int[] findMinMax(int[] arr) {
        int min = arr[0]; 
        int max = arr[0]; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new int[]{min, max}; // Return min and max as an array
    }
}