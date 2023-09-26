import java.util.Scanner;
/* We generate public class Fibonacci */
public class Fibonacci {
    public static void main(String[] args) {
        FibonacciData fibData = createFibonacci();
        checkForTriangleNumbers(fibData.sequence);
    }

    static class FibonacciData {
        int size;
        long[] sequence;
    }
    /* We create method that creates fibonacci dynamical array depending on number inputted */
    static FibonacciData createFibonacci() {
        FibonacciData fibData = new FibonacciData();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter M Fibonacci numbers (Max 93): ");
        int randAmount;

        while (true) {
            try {
                randAmount = Integer.parseInt(scanner.nextLine());

                if (randAmount >= 1 && randAmount <= 93) {
                    break;
                } else {
                    System.out.print("\nTry to input M one more time:  ");
                }
            } catch (NumberFormatException e) {
                System.out.print("\nTry to input M one more time:  ");
            }
        }

        fibData.size = randAmount;
        fibData.sequence = new long[randAmount];

        fibData.sequence[0] = 0;
        if (randAmount > 1) {
            fibData.sequence[1] = 1;

            for (int i = 2; i < randAmount; i++) {
                fibData.sequence[i] = fibData.sequence[i - 1] + fibData.sequence[i - 2];
            }
        }

        return fibData;
    }
    /* We create method that checks if Fibonacci number in sequence is triangle number */
    static void checkForTriangleNumbers(long[] dynamicFibon) {
        for (int i = 0; i < dynamicFibon.length; i++) {
            long suspect = dynamicFibon[i];
            long possibleTriangle = suspect * 8 + 1;
            if(suspect >= Long.MAX_VALUE/8){
                System.out.println((i + 1) + ". " + suspect + " not able to check");
                continue;
            }
            // Continue with your code if no exception is thrown
            double sqrt = Math.sqrt(possibleTriangle);
            if(sqrt == (int) sqrt){
                System.out.println((i + 1) + ". " + suspect + " is a triangle number");
            }
            else {
                System.out.println((i + 1) + ". " + suspect + " is not");
            }

        }
    }
}