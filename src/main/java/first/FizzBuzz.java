package first;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzzFunc(3);
        fizzBuzzFunc(5);
        fizzBuzzFunc(15);
        fizzBuzzFunc(4);

    }

    private static void fizzBuzzFunc(int i) {
        if (i%3 == 0 && i%5==0) {
            System.out.println("FizzBuzz");
        }
        else if (i%3 == 0) {
            System.out.println("Fizz");
        }
        else if (i%5 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println(i);
        }
    }

}
