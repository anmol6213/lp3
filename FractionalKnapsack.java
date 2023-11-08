import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {
    public static double getMaxValue(Item[] items, int capacity) {

        Arrays.sort(items, (item1, item2) -> Double.compare((double) item2.value / item2.weight,(double) item1.value / item1.weight));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }


        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
  
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            System.out.print("Enter the value of item " + (i + 1) + ": ");
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value for the knapsack: " + maxValue);

        scanner.close();
    }
}
