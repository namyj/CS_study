package backjoon.backtracking;

import java.io.*;
import java.util.*;

public class Prob15649 {
    static int n;
    static int m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    static BufferedReader br;
    static BufferedWriter bw;
    // k : 0 ~ m-1 (순열의 k 번째 숫자)
    public static void func(int k) throws IOException {

        System.out.println("k: "+k+" arr: "+Arrays.toString(arr)+"\n");
        if (k == m) {
            for (int i=0; i < m; i++)
                bw.write(arr[i] + " ");

            bw.write("\n");
        }

        // i : 1~n > 1부터 n 숫자 중 사용하지 않은 숫자 하나 선택
        for (int i=1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
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

        func(0);

        bw.flush();
        bw.close();
        br.close();


    }
}