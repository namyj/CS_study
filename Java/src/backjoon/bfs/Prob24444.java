package backjoon.bfs;

import java.util.*;
import java.io.*;

/**
 * 접근법
 * - 인접 행렬 > 메모리 초과
 * - 인접 리스트
 */

public class Prob24444 {
    /**
     * 인접 행렬 > 메모리 초과
     * 희소 그래프의 경우 인접 리스트로 구현하는 것이 좋음
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        int[][] graph = new int[n][n]; // 인접 행렬
        boolean[] visited = new boolean[n]; // 방문 표시
        int[] result = new int[n+1];

        // 1. 그래프 표시
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선
            graph[u][v] = 1;
            graph[v][u] = 1;
        }


        // 2. bfs 수행
        Queue<Integer> q = new LinkedList<>();

        q.add(r);
        visited[r] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int curNode = q.poll();
            result[curNode] = ++cnt;

            for (int i = 0; i < n; i++) { // 오름차순 방문
                if (graph[curNode][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 연결 리스트 사용
     * @throws IOException
     */
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        LinkedList<Integer>[] graph = new LinkedList[n+1]; // 입력값을 그대로 사용하기 위해 n + 1 로 생성
        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];

        for (int i=0; i <= n; i++) {
            graph[i] = new LinkedList<Integer>();
        }


        // 1. 그래프 표시
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선
            graph[u].add(v);
            graph[v].add(u);
        }

        // 2. 각 리스트 정렬해주기 <- 인접한 정점을 오름차순으로 방문하기 위해
        for (int i = 1; i <= n ; i++) {
            Collections.sort(graph[i]);
        }

        // 3. bfs 수행
        Queue<Integer> q = new LinkedList<>();

        visited[r] = true;
        q.add(r);

        int cnt = 0;

        while (!q.isEmpty()) {
            int curNode = q.poll();
            result[curNode] = ++cnt;

            Iterator<Integer> iter = graph[curNode].listIterator();
            while (iter.hasNext()) {
                curNode = iter.next();
                if (!visited[curNode]) {
                    visited[curNode] = true;
                    q.add(curNode);
                }
            }

        }

        // 출력
        // i번째 노드가 몇 번째 방문하는지
        for (int i = 1; i <= n; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}