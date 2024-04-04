public class MaximumSumPath {
    // Utility function to find the maximum of two integers
    private static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    // Function to find the maximum sum path in two given arrays
    // The code is similar to the merge routine of the merge sort algorithm
    private static int findMaxSum(int[] X, int[] Y, int m, int n) {
        int sum = 0;
        int sum_x = 0, sum_y = 0;
        int i = 0, j = 0;

        // Loop until both arrays are empty
        while (i < m && j < n) {
            // Handle duplicate elements in array X
            while (i < m - 1 && X[i] == X[i + 1]) {
                sum_x += X[i++];
            }

            // Handle duplicate elements in array Y
            while (j < n - 1 && Y[j] == Y[j + 1]) {
                sum_y += Y[j++];
            }

            // Compare the current elements of X and Y
            if (Y[j] < X[i]) {
                sum_y += Y[j++];
            } else if (X[i] < Y[j]) {
                sum_x += X[i++];
            } else { // Common element found
                // Include the maximum sum and move both indices
                sum += max(sum_x, sum_y) + X[i];
                i++;
                j++;
                sum_x = 0;
                sum_y = 0;
            }
        }

        // Process remaining elements in X (if any)
        while (i < m) {
            sum_x += X[i++];
        }

        // Process remaining elements in Y (if any)
        while (j < n) {
            sum_y += Y[j++];
        }

        // Include the maximum sum between the remaining sums
        sum += max(sum_x, sum_y);
        return sum;
    }

    public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};
        int m = X.length;
        int n = Y.length;

        int maxSum = findMaxSum(X, Y, m, n);
        System.out.println("The maximum sum path is: 1 → 2 → 3 → 6 → 7 → 9 → 10 → 12 → 15 → 16 → 18 → 100");
        System.out.println("The maximum sum is: " + maxSum);
    }
}