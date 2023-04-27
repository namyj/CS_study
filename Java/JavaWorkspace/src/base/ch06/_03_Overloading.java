package base.ch06;


/*
 * 메소드 오버로딩
 * - 이름은 동일하지만 파라미터 타입이 다른 함수 선언 가능
 * - 파라미터에 따라 해당 함수 실행 됨
 * 
 * 조건
 * - 메소드 이름 동일
 * - 매개변수의 개수 또는 타입이 다름
 * - 리턴타입이 다른 경우 성립 X
 */
public class _03_Overloading {
    public static int getPower(int number) {
        return number*number;
    }

    public static int getPower(String strNumber) {
        int number = Integer.parseInt(strNumber);
        return getPower(number);
    }
    
    public static void main(String[] args) {
        System.out.println(getPower("10"));
        System.out.println(getPower(2));
    }
}
