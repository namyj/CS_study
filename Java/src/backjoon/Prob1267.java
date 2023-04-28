package backjoon;

import java.util.Scanner;

public class Prob1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();
        int call;
        int yCost = 0;
        int mCost = 0;

        for (int i = 0; i < nVal ; i++) {
            call = sc.nextInt();
            yCost += 10 * (call / 30 + (call % 30 > 0 ? 1 : 0));
            mCost += 15 * (call / 60 + (call % 60 > 0 ? 1 : 0));
        }

        if (yCost == mCost) {
            System.out.printf("Y M %d", yCost);
        } else if (yCost < mCost) {
            System.out.printf("Y %d", yCost);
        } else {
            System.out.printf("M %d", mCost);
        }

    }
}

/**
 * 2
 * 60 65
 * 정답 > Y M 60
 * 오답 > M 45
 *
 * 접근법
 * - 경계값 입력시 동작 확인 필요
 */
