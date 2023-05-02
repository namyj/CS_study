package backjoon.base2;

import java.util.Scanner;
// 입력: 연도
// 출력: 윤년 여부 (1 = 윤년, 0 = 아님)
// 윤년 조건
// - 4의 배수 && 100의 배수가 아닐 때
// - 400의 배수일 때

public class Prob2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
