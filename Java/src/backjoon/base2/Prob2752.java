package backjoon.base2;

import java.util.Scanner;

public class Prob2752 {
    public static void main(String[] args) {
        // 입력: 세수
        // 출력: 세 숫자를 오름차순 정렬한 결과
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int[] result = {num1, num2, num3};

        for (int i=0; i < result.length - 1; i++) {
            for (int j = i+1; j < result.length; j++) {
                if (result[i] > result[j]) {
                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }

    }
}

/**
 * 접근 순서
 * - 삼항 연산자 -> 처리 제대로 안됨
 * - 버블 정렬
 */