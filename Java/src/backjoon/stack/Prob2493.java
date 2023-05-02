package backjoon.stack;

import java.io.*;
import java.util.*;

public class Prob2493 {
    /**
     * 접근법 - 배열로 스택 구현 > 시간 초과
     */
    public static void mySolution１() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int pos;

        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pos = i;

            while (pos > 0) {
                if (arr[pos - 1] >= arr[i]) {
                    bw.write(String.valueOf(pos) + " ");
                    break;
                } else {
                    pos--;
                }
            }

            if (pos <= 0) {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 접근법 - Stack 클래스 사용 > 출력 초과
     * - 알고리즘이 틀린 것 같음
     * 반례
     * input)
     * 9
     * 10 6 7 4 5 2 3 1 9
     * Answer)
     * 0 1 1 3 3 5 5 7 1
     */
    public static void mySolution2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int curNum;
        int pos;

        for (int i = 1; i <= n ; i++) {
            curNum = Integer.parseInt(st.nextToken());

            pos = i - 1;
            while (!stack.isEmpty()) {
                if (stack.peek() >= curNum) {
                    bw.write(String.valueOf(pos) + " ");
                    break;
                }
                stack.pop();
                pos--;
            }

            if (stack.isEmpty()) {
                bw.write("0 ");
            }
            stack.push(curNum);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        int top;

        for (int i = 1; i <= n ; i++) {
            top = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= top) {
                    bw.write(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                bw.write("0 ");
            }
            stack.push(new int[]{i, top});
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

