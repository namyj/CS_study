package backjoon.bfs;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 시작 위치
        int k = Integer.parseInt(st.nextToken()); // 도착 위치

        // bfs
        // 시작 노드
        Queue<int[]> q = new LinkedList<>();
        LinkedList<Integer> visited = new LinkedList<>();
        int sec = 0;

        visited.add(n);
        q.add(new int[] {n, sec});

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int x = curNode[0];
            sec = curNode[1];
            if (x == k) { // 도착 > 종료
                break;
            }

            // 3가지 방향 이동

            if (!visited.contains(x-1) && x-1 >= 0 ) {
                q.add(new int[]{x-1, sec + 1});
                visited.add(x-1);
            }
            if (!visited.contains(x+1) && x+1 <= 100000) {
                q.add(new int[]{x+1, sec + 1});
                visited.add(x+1);
            }
            if (!visited.contains(2*x) && 2*x <= 100000) {
                q.add(new int[]{2*x, sec + 1});
                visited.add(2*x);
            }

        }

        System.out.println(sec);
        br.close();
    }
}