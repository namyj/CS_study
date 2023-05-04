package backjoon.deque;

import java.util.*;
import java.io.*;

/**
 * - 찾을 숫자가 어디 위치해있는지 > 덱을 LinkedList로 구현해서 indexOf 로 찾기
 * - 찾을 숫자가 중간에 위치 > 2 연산 수행하는 것이 최소 횟수
 */
public class Prob1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 1. 디큐 생성 및 초기화
        LinkedList<Integer> dq = new LinkedList<>();

        for (int i=1; i <= n ; i++) {
            dq.offer(i);
        }

        // 2. 숫자 찾기 수행
        input = br.readLine().split(" ");
        int cnt = 0;

        for (int i=0; i < m; i++) {
            int curNum = Integer.parseInt(input[i]);
            int idx = dq.indexOf(curNum);

            if (idx <= dq.size()/2) { // 2 연산
                while (dq.peek() != curNum) {
                    cnt++;
                    int tmp = dq.pollFirst();
                    dq.offerLast(tmp);
                }
            } else { // 3 연산
                while (dq.peek() != curNum) {
                    cnt++;
                    int tmp = dq.pollLast();
                    dq.offerFirst(tmp);
                }
            }
            dq.pollFirst();
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();

    }

    public static void refactSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 디큐 생성 및 초기화
        LinkedList<Integer> dq = new LinkedList<>();

        for (int i=1; i <= n ; i++) {
            dq.offer(i);
        }

        // 2. 숫자 찾기 수행
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        for (int i=0; i < m; i++) {
            int curNum = Integer.parseInt(st.nextToken());
            int idx = dq.indexOf(curNum);

            if (idx <= dq.size()/2) { // 2 연산
                while (dq.peek() != curNum) {
                    cnt++;
                    int tmp = dq.pollFirst();
                    dq.offerLast(tmp);
                }
            } else { // 3 연산
                while (dq.peek() != curNum) {
                    cnt++;
                    int tmp = dq.pollLast();
                    dq.offerFirst(tmp);
                }
            }
            dq.pollFirst();
        }

        System.out.println(cnt);
        br.close();
    }
}