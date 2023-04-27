package base.ch02;

// 삼항 연산자
public class _05_Operator5 {
    public static void main(String[] args) {
        // 결과 = 조건 ? (참일 때 결과값) : (거짓일 때 결과값);
        int x = 5;
        int y = 6;
        int max = (x>y) ? x : y;
        System.out.println(max);

        int min = (x<y) ? x : y;
        System.out.println(min);
    }
}
