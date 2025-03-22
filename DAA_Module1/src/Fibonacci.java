import java.util.Scanner;

public class Fibonacci {
    public static int fibo (int num) {
        if (num <= 1) {
            return num;
        }
        return fibo(num - 1) + fibo (num - 2);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0 ; i < num ; i++)
            System.out.print(fibo(i) + " ");
    }
}
