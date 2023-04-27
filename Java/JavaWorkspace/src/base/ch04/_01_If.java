package base.ch04;

// 조건문 if
// 들여쓰기 X
public class _01_If {
    public static void main(String[] args) {
        int hour = 10;
        // 한 문장 실행
        if (hour > 0)
            System.out.println("0");


        if (hour > 14) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }

        hour = 10;
        boolean coffeee = false;

        if (hour < 14 && coffeee) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
