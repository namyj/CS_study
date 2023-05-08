package backjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 오답 이유
 * 1. x+1, x-1, x*2 이동시 visited 배열에 넣지 않음
 * 2. x+1, x-1, x*2 이동시 이동 가능한 범위 체크하지 않음
 * 3. x+2 로 이동함
 */
public class Prob1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 시작 위치
        int k = Integer.parseInt(st.nextToken()); // 도착 위치

        // bfs
        // 시작 노드
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        int sec = 0;

        visited[n] = true;
        q.add(new int[] {n, sec});

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int x = curNode[0];
            sec = curNode[1];
            if (x == k) { // 도착 > 종료
                break;
            }

            // 3가지 방향 이동
            if (x-1 >= 0 && !visited[x-1]) {
                q.add(new int[]{x-1, sec + 1});
                visited[x-1] = true;
            }
            if (x+1 <= 100000 && !visited[x+1]) {
                q.add(new int[]{x+1, sec + 1});
                visited[x+1] = true;
            }

            if (2*x <= 100000 && !visited[2*x]) {
                q.add(new int[]{2*x, sec + 1});
                visited[x*2] = true;
            }
        }

        System.out.println(sec);
        br.close();
    }
}