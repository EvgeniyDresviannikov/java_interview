package first;

public class Fibonacci {
    public static void main(String[] args) {
        printFibonacci(0);
        printFibonacci(1);
        printFibonacci(2);
        printFibonacci(3);
        printFibonacci(4);
        printFibonacci(5);
        printFibonacci(6);
        printFibonacci(7);

    }

    private static void printFibonacci(long n) {
        long prev_prev = 0;
        long prev = 1;
        long sum = 0;

        if (n == 0) {
            System.out.println(prev_prev);
            return;
        }
        if (n == 1) {
            System.out.println(prev);
            return;
        }

        for (int i = 2; i <= n; i++) {
            sum = prev_prev + prev;
            prev_prev = prev;
            prev = sum;
        }
        System.out.println(sum);
    }
}
