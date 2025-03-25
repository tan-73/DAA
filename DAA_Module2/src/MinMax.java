import java.util.Scanner;

class MinMax {
    static class Pair {
        int min, max;
    }

    static Pair findMinMax(int arr[], int low, int high) {
        Pair result = new Pair();

        if (low == high) {
            result.min = result.max = arr[low];
            return result;
        }

        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result.min = arr[low];
                result.max = arr[high];
            } else {
                result.min = arr[high];
                result.max = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;
        Pair left = findMinMax(arr, low, mid);
        Pair right = findMinMax(arr, mid + 1, high);

        result.min = Math.min(left.min, right.min);
        result.max = Math.max(left.max, right.max);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findMinMax(arr, 0, n - 1);
        System.out.println("Minimum: " + result.min);
        System.out.println("Maximum: " + result.max);
        
        sc.close();
    }
}