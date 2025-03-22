import java.util.Scanner;

public class Unique {
    public static boolean checker (int[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = i + 1 ; j < arr.length ; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++)
            arr[i] = sc.nextInt();
        if (checker(arr))
            System.out.println("Elements are unique");
        else
            System.out.println("Elements are not unique");
        }
    }
