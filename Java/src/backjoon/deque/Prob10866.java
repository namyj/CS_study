package backjoon.deque;

import java.util.*;
import java.io.*;

public class Prob10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int head = n / 2;
        int tail = n / 2;

        for (int i = 0; i < n ; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push_front":
                    arr[--head] = Integer.parseInt(command[1]);
                    break;
                case "push_back":
                    arr[tail++] = Integer.parseInt(command[1]);
                    break;
                case "pop_front":
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[head++]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "pop_back":
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[--tail]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    int cnt = tail - head > 0 ? tail - head : 0;
                    bw.write(String.valueOf(cnt) + "\n");
                    break;
                case "empty":
                    if (tail - head > 0) {
                        bw.write("0\n");
                    } else {
                        bw.write("1\n");
                    }
                    break;
                case "front":
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[head]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                default: // back
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[tail - 1]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
            }
        }


        bw.flush();
        br.close();
        bw.close();

    }
}
