import java.util.Scanner;
import java.util.Arrays;

class Item {
    float weight, profit, ratio;

    Item(float weight, float profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = profit / weight;
    }
}

public class Misc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("********* KNAPSACK PROBLEM *******");
        System.out.print("Enter the total number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        
        System.out.println("Enter profit and weight of each item : ");
        for (int i = 0 ; i < n ; i++) {
        	float weight = sc.nextFloat();
        	float profit = sc.nextFloat();
        	items[i] = new Item(profit, weight);
        }

        /*
        System.out.println("Enter the weight of each item:");
        float[] weights = new float[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextFloat();
        }

        System.out.println("Enter the profit of each item:");
        for (int i = 0; i < n; i++) {
            float profit = sc.nextFloat();
            items[i] = new Item(weights[i], profit);
        }
        */

        System.out.print("Enter the knapsack capacity: ");
        float capacity = sc.nextFloat();

        Arrays.sort(items, (a, b) -> Float.compare(b.ratio, a.ratio)); // Sort by Profit/Weight ratio (Descending)

        System.out.println("\nItems sorted by Profit/Weight ratio:");
        displayInfo(items);

        float maxProfit = knapsack(items, capacity);
        System.out.println("\nMaximum profit: " + maxProfit);
        
        System.out.println("*************************************");
        sc.close();
    }

    static void displayInfo(Item[] items) {
        System.out.println("ITEM\tWEIGHT\tPROFIT\tRATIO(PROFIT/WEIGHT)");
        for (int i = 0; i < items.length; i++) 
            System.out.println((i + 1) + "\t" + items[i].weight + "\t" + items[i].profit + "\t" + items[i].ratio);
    }

    static float knapsack(Item[] items, float capacity) {
        float maxProfit = 0;
        
        for (Item item : items) {	
            if (capacity >= item.weight) { // Take full item
                maxProfit += item.profit;
                capacity -= item.weight;
            } else { // Take fractional part
                maxProfit += item.ratio * capacity;
                break;
            }
        }
        return maxProfit;
    }
}