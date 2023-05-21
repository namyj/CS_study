package backjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 접근법 
 * - merge sort > 시간 초과
 * - counting sort > 정답
 *  수의 범위가 1000만 이하로 counting sort를 사용하기에 적절
 */
public class Prob10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[10000001];

        for (int i=0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            numList[c]++;
        }

        for (int i=0; i < numList.length; i++) {
            if (numList[i] > 0) {
                numList[i]--;
                bw.write(i-- + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }


}
