package lecture;

import java.util.Scanner;

/**
 * 입력: 
 *  - 입력될 숫자의 개수 N (1 <= N <= 100)
 *  - 공백없이 나열된 숫자들
 * 출력: 입력된 숫자를 모두 합한 결과
 *
 * 접근법
 * - N의 범위로 인해 숫자를 int, long 으로 입력받을 수 없음 (범위 초과) > String
 * - string.toCharArray -> 각 char
 * - 각 char > int 변환 후 합치기
 *      - '1'의 아스키 코드 값 = 49
 */
public class Prob11720 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length ; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();
        sc.nextLine();
        char[] input = sc.nextLine().toCharArray();
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += (input[i] - 48);
        }
        System.out.println(sum);
    }
}
