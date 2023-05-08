package backjoon.bfs;

import java.io.*;
import java.util.*;

// 출력: 토마토가 전부 익을 때까지 걸리는 최소 일수
// 처음부터 모든 토마토 익어있음 > 0 / 토마토가 모두 익지 못하는 상황 > -1

/**
 * 접근법
 * - 인접한 토마토 익음, 모두 익는 최소 일수 > BFS
 * - 시작점 (1) 여러 개, 최소 일수를 구해야한다 > BFS를 수행하기 전에 모든 시작점을 먼저 큐에 넣음
 * - 모두 방문이 불가능한 경우 -1 출력 
 *      > BFS를 수행하기 전에 방문해야하는 칸 수 세서, BFS에서 칸을 방문할 때마다 -1 
 *      > BFS가 끝난 후 해당 값이 0보다 크면 > -1 출력
 */
public class Prob7576 {
    public static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int[][] arr = new int[n][m];

        // 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 없는 칸 
        Queue<int[]> q = new LinkedList<>();
        int day = 0;
        int numZero = 0;

        for (int i=0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j=0; j < m ; j++) {
                if (arr[i][j] == -1) continue;

                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j, day});
                }

                numZero++;
            }
        }

        // 인접점 방문   
        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int x = curNode[0];
            int y = curNode[1];
            day = curNode[2];
            numZero--;

            for (int k=0; k < pos.length; k++) {
                int nx = x + pos[k][0];
                int ny = y+ pos[k][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] != 0) continue; // 방문할 필요 X
                arr[nx][ny] = 1;
                q.add(new int[] {nx, ny, day + 1});
            }
        }

        if (numZero > 0) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }

    }
}