package backjoon.backtracking;


import java.io.*;
import java.util.*;

public class Prob15657 {
    static int n;
    static int m;
    static int[] arr;
    static int[] result;

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

        // result[k-1] <= result[k]
        for (int i=st; i < n; i++) {
            result[k] = arr[i];
            func(k+1, i);
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
        result = new int[m];

        func(0, 0);

        bw.flush();
        bw.close();
        br.close();

    }
}