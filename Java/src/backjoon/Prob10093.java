package backjoon;

import java.io.*;
import java.util.Scanner;

/**
 * 입력 값 조건
 * 1 ≤ A, B ≤ 1000
 * 반례
 * - 두 수가 동일할 때
 * - 14 8 같이 앞에 수가 뒤에 수보다 작을 때
 *
 */

/**
 * 접근법
 * - Scanner > 30 점
 * - InputStream, Buffered 사용 > 30 점
 * - 입력값의 범위가 큰 경우 존재(10^15), long 타입 사용 > 100 점
 */
public class Prob10093 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int aNum = sc.nextInt();
        // int bNum = sc.nextInt();
        // int cnt = Math.abs(bNum - aNum) - 1;
        //
        // if (cnt < 0) cnt = 0; // 두 수가 동일할 때
        //
        // System.out.println(cnt);
        // for (int i = 0 ; i < cnt; i++) {
        //     System.out.printf("%d ", Math.min(aNum, bNum) + i + 1);
        // }

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);

        String[] iNum = br.readLine().split(" ");
        long cnt = Math.abs(Long.parseLong(iNum[1]) - Long.parseLong(iNum[0])) - 1;
        if (cnt < 0) cnt = 0;

        System.out.println(cnt);
        for (int i = 0 ; i < cnt; i++) {
            bw.write(String.valueOf(Math.min(Long.parseLong(iNum[1]), Long.parseLong(iNum[0])) + i + 1));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
