package backjoon.backtracking;

import java.io.*;
import java.util.*;

public class Prob1182 {
    public static int n;
    public static int s;
    public static int result = 0;
    public static int[] arr;
    public static boolean[] isUsed;


    /**
     * 접근법
     * - 방법1) k=0 에서 시작해서 백트래킹 > 시간 초과
     *  반례) 5 0
     *       0 0 0 0 0
     *       > 답 31 (5C1 + 5C2?? + 5C3 + 5C4 + 5C5 = 1 + 2 + 6 + 20 + 5)
     *
     *       5 -2
     *       -1 -1 -1 -1 -1
     *       > 답 20 (5 * 4)
     *
     * - 동일한 숫자 가능 & 순서 고려
     * - 방법2)
     * - 시작점을  0 ~ n-1 변경
     * - 앞에서 부터 숫자를 더해감  > start 이전에 있는 숫자는 검색할 필요 없음 (이미 더해봤던 숫자이기 때문)
     */
    
    // 백트래킹 시작 함수
    // 0 ~ n-1 시작점을 변경하며 백트래킹 수행
    public static void func() {
        for (int i=0; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sum(arr[i], i+1);
                isUsed[i] = false;
            }
        }
    }

    // 백트래킹 함수
    // k == s 여도 종료하지 않음 > 원소 중 0 이 있을 수 있음
    public static void sum(int k, int start) {
        if (k == s) {
            result++;
        }

        for (int i=start; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sum(k + arr[i], i+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        isUsed = new boolean[n];

        func();

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}