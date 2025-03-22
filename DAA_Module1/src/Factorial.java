import java.util.*;

public class Factorial {
    public static int factorial (int num) {
        int fact;
        if (num == 1)
                return 1;
        return num * factorial(num - 1);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt();
        System.out.println(factorial(num));
    }
}
