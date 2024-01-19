import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumNotes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the size of currency denominations
        System.out.print("Enter the size of currency denominations: ");
        int size = scanner.nextInt();

        // Taking input for currency denominations
        System.out.println("Enter the currency denominations values:");
        int[] denominations = new int[size];
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        // Taking input for the amount to be paid
        System.out.print("Enter the amount you want to pay: ");
        int amount = scanner.nextInt();

        // Calculating and printing the minimum number of notes
        Map<Integer, Integer> paymentNotes = minimumNotes(denominations, amount);
        System.out.println("Your payment approach in order to give the minimum number of notes will be:");

        for (Map.Entry<Integer, Integer> entry : paymentNotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<Integer, Integer> minimumNotes(int[] denominations, int amount) {
        Arrays.sort(denominations);
        Map<Integer, Integer> paymentNotes = new HashMap<>();

        for (int i = denominations.length - 1; i >= 0; i--) {
            while (amount >= denominations[i]) {
                paymentNotes.put(denominations[i], paymentNotes.getOrDefault(denominations[i], 0) + 1);
                amount -= denominations[i];
            }
        }

        return paymentNotes;
    }
}
