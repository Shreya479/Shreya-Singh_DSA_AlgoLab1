import java.util.Scanner;

public class PayMoney {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of transactions
        System.out.print("Enter the size of transaction array: ");
        int numTransactions = scanner.nextInt();

        // Input: List of transactions
        System.out.print("Enter the values of array separated by space: ");
        int[] transactions = new int[numTransactions];
        for (int i = 0; i < numTransactions; i++) {
            transactions[i] = scanner.nextInt();
        }

        // Input: Number of targets
        System.out.print("Enter the total number of targets that need to be achieved: ");
        int numTargets = scanner.nextInt();

        for (int t = 0; t < numTargets; t++) {
            // Input: Daily target
            System.out.print("Enter the value of target: ");
            int dailyTarget = scanner.nextInt();

            // Determine at which transaction PayMoney achieves or fails to achieve the target
            int currentTotal = 0;
            int transactionNumber = 0;

            for (int i = 0; i < numTransactions; i++) {
                currentTotal += transactions[i];

                if (currentTotal >= dailyTarget) {
                    transactionNumber = i + 1;
                    break;
                }
            }

            // Output the result for each target
            if (currentTotal >= dailyTarget) {
                System.out.println("Target achieved after " + transactionNumber + " transactions");
            } else {
                System.out.println("The target is not achievable.");
            }
        }
    }
}
