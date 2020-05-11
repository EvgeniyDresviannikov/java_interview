package first;

public class Palindrom {
    public static void main(String[] args) {
        checkPalindrom("Madam i’m Adam");

    }

    private static void checkPalindrom(String s) {
        char a[] = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        for (int i = 0; i < a.length/2; i++) {
            if (a[i] != a[a.length-i-1]) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
