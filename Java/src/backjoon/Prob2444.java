package backjoon;

import java.util.Scanner;

/**
 * 규칙
 * N줄 까지 i 줄에 2i-1 별 찍기 & 가운데 정렬 (i = 1 ~ N)
 * N+1부터 2N-1 줄까지 j 줄에 2j-1 별 찍기 & 가운데 정렬 (j = N-1 ~ 1)
 */
public class Prob2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = 1; i <= nVal ; i++) {
            System.out.printf("%" + nVal + "s", "*".repeat(i));
            System.out.printf("%s\n", "*".repeat(i-1));
        }

        for (int i = nVal - 1; i > 0; i--) {
            System.out.printf("%" + nVal + "s", "*".repeat(i));
            System.out.printf("%s\n", "*".repeat(i-1));
        }
    }
}
