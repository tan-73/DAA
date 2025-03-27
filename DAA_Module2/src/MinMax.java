import java.util.Scanner;

class MinMax {
    static int[] findMinMax(int arr[], int low, int high) {
        int result[] = new int[2]; // result[0] = min, result[1] = max

        if (low == high) { 
            result[0] = result[1] = arr[low];
            return result;
        }

        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result[0] = arr[low];
                result[1] = arr[high];
            } else {
                result[0] = arr[high];
                result[1] = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;
        int left[] = findMinMax(arr, low, mid);
        int right[] = findMinMax(arr, mid + 1, high);

        result[0] = Math.min(left[0], right[0]); // Minimum
        result[1] = Math.max(left[1], right[1]); // Maximum

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

        int res[] = findMinMax(arr, 0, n - 1);
        System.out.println("Minimum: " + res[0]);
        System.out.println("Maximum: " + res[1]);

        sc.close();
    }
}
