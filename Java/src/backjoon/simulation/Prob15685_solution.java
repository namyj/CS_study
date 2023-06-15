package backjoon.simulation;

import java.io.*;
import java.util.*;

public class Prob15685_solution {

    static int n;
    static boolean[][] arr;
    static int[][] pos = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // x, y
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new boolean[101][101];

        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            drawCurve(x, y, d, g);
        }


        check();
        System.out.println(answer);


    }

    public static void drawCurve(int x, int y, int d, int g) {
        // 방향 저장
        List<Integer> d_list = new ArrayList<>();
        d_list.add(d); // 0 세대 그리기

        // 1세대 부터 순서대로 방향 저장 (이전 세대 방향의 역순으로 반시계 회전한 견과)
        for (int i=1; i <= g; i++) { // 1 세대부터 그리는 방향 저장
            for (int j=d_list.size()-1; j >= 0; j-- ) {
                int nd = (d_list.get(j)+1)%4;
                d_list.add(nd);
            }
        }

        // 맵에 표시
        arr[y][x] = true;

        for (Integer dir: d_list) {
            x += pos[dir][0];
            y += pos[dir][1];
            arr[y][x] = true;
        }

    }

    public static void check() {
        for (int i=0; i < 100; i++) {
            for (int j=0; j < 100; j++) {
                if (arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) answer++;
            }
        }
    }


}
