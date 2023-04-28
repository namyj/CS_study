package backjoon;

import java.util.Scanner;

// 입력: 9 개 숫자
// 출력: 숫자의 합이 100 인 숫자 오름차순 출력
// 9개 숫자 정렬 > 합이 100 인 숫자 찾기
public class Prob2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] iArr = new int[9];

        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = sc.nextInt();
        }

        // 1. 숫자 정렬
        for (int i = 0; i < iArr.length - 1 ; i++) {
            for (int j = i + 1; j < iArr.length; j++) {
                if (iArr[i] > iArr[j]) {
                    int temp = iArr[i];
                    iArr[i] = iArr[j];
                    iArr[j] = temp;
                }
            }
        }
        
        // 2. 숫자 조합 찾기

    }
}
