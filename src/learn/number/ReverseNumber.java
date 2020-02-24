package learn.number;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(new ReverseNumber().reverse(123));

    }

    private int reverse(int x) {
        int result = 0;

        while(x/10 > 0) {
            int temp = x%10;
            x = x/10;
            result = result * 10 + temp;
        }

        return result * 10 + x;
    }
}
