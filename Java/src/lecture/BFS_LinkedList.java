package lecture;

import java.util.*;

public class BFS_LinkedList {
    public static void main(String[] args) {
        linkedList();
    }
    // 인접 리스트로 구현
    public static void linkedList() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        boolean[] visited = new boolean[n+1]; // 방문 표시

        LinkedList<Integer>[] graph = new LinkedList[n+1]; // 전체 그래프

        for (int i = 0; i <=n ; i++) {
            graph[i] = new LinkedList<Integer>(); // 각 노드와 인접한 노드를 저장할 LinkedList
        }

        // 인접한 노드 표시 (간선 표시, 양방향)
        for (int i = 0; i < m ; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= n ; i++) {
            Collections.sort(graph[i]); // 방문 순서를 위해 오름차순 정렬, 왜?
        }

        bfsList(v, graph, visited);
    }

    public static void bfsList(int v, LinkedList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true; // 1. 시작 정점 방문
        queue.add(v);

        while (queue.size() != 0) {
            v = queue.poll(); // 2. 큐에서 노드 뽑기
            System.out.println(v + " "); // 3. 방문

            // 4. 해당 노드의 인접한 노드 확인
            Iterator<Integer> iter = graph[v].listIterator();
            while (iter.hasNext()) {
                int w = iter.next();
                if (!visited[w]) { // 4-1. 방문하지 않은 경우, 방문을 표시하고 큐에 넣기
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
