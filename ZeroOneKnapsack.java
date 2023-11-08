// public class ZeroOneKnapsack {
//     public static int knapsack(int[] values, int[] weights, int capacity) {
//         int n = values.length;
//         int[][] dp = new int[n + 1][capacity + 1];

//         for (int i = 0; i <= n; i++) {
//             for (int w = 0; w <= capacity; w++) {
//                 if (i == 0 || w == 0) {
//                     dp[i][w] = 0;
//                 } else if (weights[i - 1] <= w) {

//                     dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
//                 } else {
//                     dp[i][w] = dp[i - 1][w];
//                 }
//             }
//         }

//         return dp[n][capacity];
//     }

//     public static void main(String[] args) {
//         int[] values = { 60, 100, 120 };
//         int[] weights = { 10, 20, 30 };
//         int capacity = 50;

//         int maxValue = knapsack(values, weights, capacity);
//         System.out.println("Maximum value for the knapsack: " + maxValue);
//     }
// }

import java.util.Scanner;

public class ZeroOneKnapsack {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            System.out.print("Enter the weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int maxValue = knapsack(values, weights, capacity);
        System.out.println("Maximum value for the knapsack: " + maxValue);

        scanner.close();
    }
}
