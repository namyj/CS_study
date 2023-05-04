package backjoon.bfs;

import java.util.*;
import java.io.*;

public class Prob2178 {
    static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    /**
     * 접근법
     * - 노드를 방문할 때 이전에 방문한 노드의 칸수 + 1 을 전달
     *      최종 결과로 (N, M) 에 도착했을 때 칸 수 > 오답, 왜?
     * - 이전 방문 칸 수 + 1은 (n, m)에 도달할 때까지 방문한 노드의 수를 의미함 (depth 가 아님)
     * @param args
     * @throws IOException
     */
    public static void mySolution1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmArr = br.readLine().split(" ");
        int n = Integer.parseInt(nmArr[0]); // 정점 수
        int m = Integer.parseInt(nmArr[1]); // 간선 수

        int[][] arr = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];

        for (int i=1; i <= n; i++) {
            String input = br.readLine();
            for (int j=1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(input.charAt(j-1) + "");
            }
        }

        // 3. bfs 수행
        Queue<int[]> q = new LinkedList<>();
        int result = 0; // 칸 수

        visited[1][1] = true;
        q.add(new int[] {1, 1, 1});

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int cx = curNode[0];
            int cy = curNode[1];
            int cnt = curNode[2];
            visited[cx][cy] = true;

            if (cx == n && cy == m) {
                result = cnt;
                break;
            }

            for (int i=0; i < pos.length; i++) {
                int nx = cx + pos[i][0];
                int ny = cy + pos[i][1];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, ++cnt});
                }
            }
        }

        // 출력
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


    /**
     * 해결
     * - 시작 노드에서 해당 노드까지 depth 를 표시하고 싶음 
     * - 시작 노드 1
     * - 다음 노드 방문 표시할 때, 이전 depth + 1 로 기록하기
     * @throws IOException
     */
    public static void mySolution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmArr = br.readLine().split(" ");
        int n = Integer.parseInt(nmArr[0]); // 정점 수
        int m = Integer.parseInt(nmArr[1]); // 간선 수

        int[][] arr = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];

        for (int i=1; i <= n; i++) {
            String input = br.readLine();
            for (int j=1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(input.charAt(j-1) + "");
            }
        }

        // 3. bfs 수행
        Queue<int[]> q = new LinkedList<>();
        int result = 0; // 칸 수

        visited[1][1] = true;
        q.add(new int[] {1, 1});

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int cx = curNode[0];
            int cy = curNode[1];
            visited[cx][cy] = true;

            for (int i=0; i < pos.length; i++) {
                int nx = cx + pos[i][0];
                int ny = cy + pos[i][1];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny] && arr[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    arr[nx][ny] = arr[cx][cy] + 1;
                }
            }
        }

        // 출력
        bw.write(arr[n][m] + "");

        bw.flush();
        bw.close();
        br.close();
    }

}
