package backjoon;

import java.util.Scanner;

// Y Cost 조건
// 0~29 > 10
// 30~59 > 10 + 10
// M Cost 조건
// 0~59 > 15
// 60~119 > 15 + 15
public class Prob1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();
        int call;
        int yCost = 0;
        int mCost = 0;

        for (int i = 0; i < nVal ; i++) {
            call = sc.nextInt();
            yCost += 10 * (call / 30 + 1);
            mCost += 15 * (call / 60 + 1);
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
 * - 몫 구하고, 나머지 존재 여부 확인 > 경계값 입력시 오답
 * - 경계값 케이스 처리
 */
