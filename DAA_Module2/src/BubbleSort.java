import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.print("Enter the elements : ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        
        sort(arr);

        System.out.println("The sorted array is : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
