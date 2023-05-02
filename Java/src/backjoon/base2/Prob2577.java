package backjoon.base2;

import java.util.Scanner;

/**
 * 문자를 문자열 변환
 * - String.valueOf(char)
 * - Character.toString(char)
 * - 문자열 연결 + ""
 */
public class Prob2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mVal = 1;
        for (int i = 0; i < 3; i++) {
            mVal *= sc.nextInt();
        }

        int[] count = new int[10];
        String strVal = String.valueOf(mVal);

        for (int i = 0; i < strVal.length(); i++) {
            count[Integer.parseInt(strVal.charAt(i) + "")] += 1;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }



    }
}
