package backjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 접근법
 * 1. 수열을 돌면서 수 선택
 *      - 사용 X && 이전 수보다 큰 경우
 * 2. 다음 수 선택 - 재귀
 *      - 선택 한 수 개수 k, 탐색 시작점 i +1 전달
 */
public class Prob15655 {
    static int n;
    static int m;
    static int[] arr;
    static int[] result;
    static boolean[] isUsed;

    static BufferedReader br;
    static BufferedWriter bw;

    public static void func(int k, int st) throws IOException {
        if (k == m) {
            for (int i=0; i < m ; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=st; i < n; i++) {
            if (!isUsed[i] && k == 0) {
                result[k] = arr[i];
                isUsed[i] = true;
                func(k+1, i+1);
                isUsed[i] = false;
            } else if (!isUsed[i] && result[k-1] < arr[i]) {
                result[k] = arr[i];
                isUsed[i] = true;
                func(k+1, i+1);
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

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        isUsed = new boolean[n];
        result = new int[m];

        func(0, 0);

        bw.flush();
        bw.close();
        br.close();


    }
}