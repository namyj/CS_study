package backjoon.backtracking;

import java.io.*;
import java.util.*;

public class Prob15650 {
    static int n;
    static int m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    static BufferedReader br;
    static BufferedWriter bw;

    /**
     * 접근법
     * - 순열에 넣을 숫자 찾을 때, 이전 원소 arr[k-1] 보다 크면 선택
     * - arr[k-1] 을 사용하기 위해 > k = 1 부터 시작
     *  - k가 1 증가했으므로 base condition도 k > m 으로 변경
     * @param k
     * @throws IOException
     */
    public static void func(int k) throws IOException {
        // m개 숫자를 모두 결정 > 출력
        if (k > m) {
            for (int i=1; i <= m ; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        // k 번째 숫자 결정 > k+1 번째 숫자 결정하기
        // arr[k-1] < arr[k] -> arr[k-1] 보다 i가 클 때만 넣어주기
        for (int i=1; i <= n; i++) {
            if (!isUsed[i] && arr[k-1] < i) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
            }
        }
    }

    // 바킹독 솔루션
    // k != 0 일 때, arr[k-1] 보다 큰 수에서부터 순열에 넣을 숫자 찾기
    public static void func2(int k) throws IOException{
        if (k == m) {
            for (int i=0; i < m ; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int st = 1; // 숫자 탐색 시작 지점

        if (k != 0) st = arr[k-1] + 1;

        for (int i=st; i <= n; i++ ) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func2(k+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // func(1);
        func2(0);

        bw.flush();
        bw.close();
        br.close();


    }
}