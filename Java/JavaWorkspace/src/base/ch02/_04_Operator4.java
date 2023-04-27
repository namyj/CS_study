package base.ch02;

// 논리 연산자
public class _04_Operator4 {
    public static void main(String[] args) {
        boolean menu1 = true;
        boolean menu2 = true;
        boolean menu3 = false;
        
        // OR (one true -> true)
        System.out.println(menu1 || menu2 || menu3);

        // AND (all true -> true)
        System.out.println(menu1 && menu2 && menu3);
    
        // 비교 연산 사용
        System.out.println((5 > 3) && (3 < 1)); // false
        System.out.println((5 > 3) || (3 < 1)); // true
        // 1 < 3 < 5 // Error
        
        // 논리 부정 연산자
        System.out.println(!true);
        System.out.println(!false);
    }
}
