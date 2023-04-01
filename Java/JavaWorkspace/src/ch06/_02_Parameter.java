package ch06;

public class _02_Parameter {
    public static int power(int number) {
        return number*number;
    }
    public static int exp(int number, int e) {
        int result = 1;
        for (int i = 0; i < e; i++) {
            result *= number;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(power(2));
        System.out.println(power(3));
        System.out.println(exp(2, 2));
    }
}
