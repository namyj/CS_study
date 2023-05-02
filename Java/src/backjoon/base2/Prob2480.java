package backjoon.base2;

import java.util.Scanner;

// 입력: 주사위 3개의 눈
// 출력: 상금
// 상금 조건
// case1- 같은 눈 3개 > 10000 + (눈 값) * 1000
// case2- 같은 눈 2개 > 1000 + (눈값) * 100
// case3- 모두 다른 눈 > (가장 큰 눈 값) * 100
public class Prob2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val1 = sc.nextInt();
        int val2 = sc.nextInt();
        int val3 = sc.nextInt();
        int award; // 상금

        if (val1 == val2 || val2 == val3 || val3 == val1) {
            if (val1 == val2 && val2 == val3) { // case 1
                award = 10000 + val1 * 1000;
            } else { // case 2
                int sameNum = val1 == val2 ? val1 : val3;
                award = 1000 + sameNum * 100;
            }
        } else { // case 3
            // award = ((val1 > val2? val1 : val2) > val3? (val1 > val2? val1 : val2) : val3) * 100;
            award = Math.max(Math.max(val1, val2), val3) * 100;
        }

        System.out.println(award);
    }
}
