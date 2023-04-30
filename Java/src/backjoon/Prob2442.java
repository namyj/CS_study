package backjoon;

import java.util.Scanner;

/**
 * 조건
 * - 2N - 1 별 찍기
 * - 가운데 정렬
 */
public class Prob2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = 1; i <= nVal; i++) {
            System.out.printf("%" + nVal + "s", "*".repeat(i));
            System.out.printf("%s\n", "*".repeat(i-1));
        }
    }
}
