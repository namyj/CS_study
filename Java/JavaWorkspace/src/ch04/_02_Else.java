package ch04;

// 조건문 if - else if
public class _02_Else {
    public static void main(String[] args) {
        int hour = 10;
        if (hour < 10) {
            System.out.println("1");
        } else if (hour < 15){
            System.out.println("2");
        } else {
            System.out.println("3");
        }
    }
}
