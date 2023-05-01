package backjoon;

import java.util.Scanner;

/**
 * 접근법
 * - 6 == 9
 */
public class Prob1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomNum = String.valueOf(sc.nextInt());
        int[] arr = new int[10]; // 0 ~ 9
        int setCnt = 0;

        int curNum;

        for (int i = 0; i < roomNum.length(); i++) {
            curNum = Integer.parseInt(roomNum.charAt(i) + "");
            // System.out.println(curNum);

            if (curNum == 6 || curNum == 9) {
                if (arr[6] + arr[9] >= setCnt * 2) {
                    // System.out.println("case 1");
                    setCnt++;
                    arr[curNum]++;
                } else {
                    // System.out.println("case 2");
                    arr[curNum]++;
                }
            } else {
                if (arr[curNum] >= setCnt) {
                    // System.out.println("case 3");
                    setCnt++;
                    arr[curNum]++;
                } else {
                    // System.out.println("case 4");
                    arr[curNum]++;
                }
            }
        }

        System.out.println(setCnt);
    }
}
