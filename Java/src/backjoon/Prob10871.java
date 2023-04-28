package backjoon;

import java.util.Scanner;

public class Prob10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();
        int xVal = sc.nextInt();
        int[] arr = new int[nVal]; // 길이 N인 배열

        for (int i = 0; i < arr.length ; i++) {
            int tempNum = sc.nextInt();
            if (tempNum < xVal) {
                System.out.printf("%d ", tempNum);
            }
        }
    }
}
