package backjoon.bfs;

// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

/**
 * 접근법
 * - 배열 구현 > 메모리 초과
 * - LinkedList 구현 > 틀림, 왜??
 */
public class Prob24445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] graph = new LinkedList[n+1]; // 그래프
        boolean[] visited = new boolean[n+1]; // 방문
        int[] result = new int[n+1];

        for (int i=1; i <= n ; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        for (int i=0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i=1; i <= n ; i++) {
            Collections.sort(graph[i], Collections.reverseOrder()); // 내림차순
        }

        Queue<Integer> q = new LinkedList<>();

        // 시작 정점
        visited[1] = true;
        q.add(1);

        int cnt = 1;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            result[curNode] = cnt++;

            Iterator<Integer> iter = graph[curNode].listIterator();
            while (iter.hasNext()) {
                int nextNode = iter.next();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }

        for (int i=1; i <= n ; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}