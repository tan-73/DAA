import java.util.Scanner;
import java.lang.Math;


public class Haversine {
    public static double calculate(double lat1, double lon1, double lat2, double lon2) {
        double dLat = (lat2 - lat1) * Math.PI / 180.0;
        double dLon = (lon2 - lon1) * Math.PI / 180.0;
        
        lat1 = (lat1) * Math.PI / 180.0;
        lat2 = (lat2) * Math.PI / 180.0;

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));

        return rad * c;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the first latitute : ");
        double lat1 = sc.nextDouble();
        System.out.println("Enter the second longitude : ");
        double lon1 = sc.nextDouble();
        
        System.out.println("Enter the second latitude : ");
        double lat2 = sc.nextDouble();
        System.out.println("Enter the second longitude : ");
        double lon2 = sc.nextDouble();

        double result = calculate(lat1, lon1, lat2, lon2);

        System.out.println(result+" kilometres");
    }
}
