package OOP;
import java.util.Scanner;

public class Fibonacci3 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the Fibonacci series: ");
        int n = scanner.nextInt();

        System.out.print("Do you want the Fibonacci series in numbers or words? (N/W): ");
        String choice = scanner.next().toUpperCase();

        int[] series = new int[n];
        series[0] = 0;
        if (n > 1) {
            series[1] = 1;
            for (int i = 2; i < n; i++) {
                series[i] = series[i - 1] + series[i - 2];
            }
        }

        if (choice.equals("N")) {
            System.out.println("Fibonacci Series in Numbers:");
            for (int num : series) {
                System.out.print(num + " ");
            }
        } else if (choice.equals("W")) {
            NumberWords numberWords = new NumberWords();
            System.out.println("Fibonacci Series in Words:");
            for (int num : series) {
                System.out.print(numberWords.convertToWords(num) + " ");
            }
        } else {
            System.out.println("Invalid choice. Please choose 'N' for numbers or 'W' for words.");
        }
    }

    static class NumberWords {
        private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

        public String convertToWords(int num) {
            if (num == 0)
                return "Zero";
            String words = "";
            int index = 0;
            do {
                int n = num % 1000;
                if (n != 0)
                    words = convertHundreds(n) + thousands[index] + " " + words;
                index++;
                num /= 1000;
            } while (num > 0);
            return words.trim();
        }

        private String convertHundreds(int num) {
            String current;
            if (num % 100 < 20) {
                current = ones[num % 100];
                num /= 100;
            } else {
                current = ones[num % 10];
                num /= 10;
                current = tens[num % 10] + current;
                num /= 10;
            }
            if (num == 0)
                return current;
            return ones[num] + "Hundred" + current;
        }
    }
}
