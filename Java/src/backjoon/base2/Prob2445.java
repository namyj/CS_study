package backjoon.base2;

import java.util.Scanner;

/**
 * prinf("%s")
 * - %ns : n>0 우측 정렬 / n<0 좌측 정렬
 * - n을 할당하지 않으면, 문자열의 길이만큼 공간이 출력됨 (좌측정렬처럼 보이지만 X)
 */
public class Prob2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = 1; i <= nVal ; i++) {
            System.out.printf("%-" + nVal + "s", "*".repeat(i));
            System.out.printf("%" + nVal + "s\n", "*".repeat(i));
        }

        for (int i = nVal - 1; i > 0; i--) {
            System.out.printf("%-" + nVal + "s", "*".repeat(i));
            System.out.printf("%" + nVal + "s\n", "*".repeat(i));
        }
    }
}
