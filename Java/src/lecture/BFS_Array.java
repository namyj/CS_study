package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        boolean[] visited = new boolean[n+1]; // 방문 표시

        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i < m ; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1][v2] = 1;
            graph[v1][v2] = 1;
        }

        // System.out.println("BFS - 인접 행렬");
        bfsArray(v, graph, visited);
    }

    public static void bfsArray(int v, int[][] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length -1;

        q.add(v); // 1. 시작 노드 큐에 넣기
        visited[v] = true;

        while (!q.isEmpty()) {
            v = q.poll(); // 2. 큐에서 방문할 노드 뽑기
            System.out.println(v + " "); // 3. 노드 방문

            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && !visited[i]) { // 4. 노드와 인접하고, 방문하지 않은 노드 큐에 넣기
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
