package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kruskal {
    int[] parant;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeConunt = Integer.parseInt(st.nextToken());

        // 배열로 트리를 표현
        parant = new int[nodeCount];
        
        // 초기) 자기 자신이 대표인 서로소 집합으로 초기화
        for (int i = 0; i < nodeCount ; i++) {
            parant[i] = i;
        }

        // 간선 정보
        int[][] edges = new int[edgeConunt][3];
        for (int i = 0; i < edgeConunt; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        // 1. 간선을 가중치 기준에서 정렬
        Arrays.sort(edges, Comparator.comparing(edge -> edge[2]));

        // 2. 간선을 가중치 순서대로 순회하면서 고른다, edgeCount -1 까지
        int picked = 0;

        int totalWeight = 0;
        List<String> pickedEdges = new ArrayList<>();

        for (int i = 0; i < edgeConunt ; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            
            // 2-1. 해당 간선을 선택했을 때 사이클이 생기는지 확인
            if (findSet(start) != findSet(end)) {
                union(start, end);
                picked++;

                totalWeight += edges[i][2];
                pickedEdges.add(Arrays.toString(edges[i]));
            }

            // 3. 선택한 간선의 개수가 (정점의 개수) - 1 까지 반복
            if (picked == nodeCount -1 ) break;
        }

        System.out.println(totalWeight);
        System.out.println(pickedEdges);
    }

    // 대표 원소를 출력
    // 부모가 자기 자신일 때까지 재귀 호출
    public int findSet(int node) {
        if (parant[node] != node)
            return findSet(parant[node]);
        else return parant[node];
    }

    // y가 속한 집합을 x 가 속한 집합에 합친다
    // y가 속한 집합의 대표자의 부모노드를 x 로 넣어준다.
    public void union(int x, int y) {
        parant[findSet(y)] = findSet(x);
    }

    public static void main(String[] args) throws IOException {
        new Kruskal().solution();
    }

}
