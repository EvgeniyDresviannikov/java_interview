package first;

public class Hundred {
    public static void main(String[] args) {
        Hundred hundred = new Hundred();

        hundred.calculateAndPrint(1111);
        hundred.calculateAndPrint(1211);

    }

    void calculateAndPrint(int n) {
        if (n / 100 % 2 == 0) System.out.println(n + 100);
        else System.out.println(n * 2);
    }
}
