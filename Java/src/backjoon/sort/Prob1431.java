package backjoon.sort;

import java.io.*;
import java.util.*;

/*
정렬 조건
- 길이가 짧은 것
- 자리수 숫자의 합이 작은 것 (숫자만)
- 사전 순 (숫자 > 알파벳)

1. Arrays.sort(arr) : 사전 순 정렬
2. Arrays.sort(arr, (s1, s2) -> ... ) : 길이가 다르면 길이 순 정렬 > 길이가 같으면 숫자의 합으로 정렬
*/
public class Prob1431 {
    static int n;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        for (int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }

        // 사전 순 정렬
        Arrays.sort(arr);

        // 길이에 따라 > 길이 순, 숫자 합 정렬
        Arrays.sort(arr, (s1, s2) ->
                s1.length() == s2.length() ? sumString(s1) - sumString(s2) : s1.length() - s2.length());

        for (int i=0; i<n ; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int sumString(String s) {
        int sum = 0;
        for (int i=0; i< s.length(); i++) {
            int tmp = (int) s.charAt(i);
            if (tmp >= 48 && tmp <= 57) {
                sum += (tmp - 48);
            }
        }
        return sum;
    }
}