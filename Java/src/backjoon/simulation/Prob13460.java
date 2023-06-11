package backjoon.simulation;

/*
입력
5 5
#####
#..B#
#.#.#
#RO.#
#####
결과
1

입력
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######

결과
5

입력
7 7
#######
#..R#B#
#.#####
#.....#
#####.#
#O....#
#######

결과
5

입력
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.#.#..#
#...#.O#.#
##########

결과
-1

입력
3 7
#######
#R.O.B#
#######

결과
1

입력
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.##...#
#O..#....#
##########

결과
7

입력
3 10
##########
#.O....RB#
##########

결과
-1
 */

import java.io.*;
import java.util.*;

public class Prob13460 {
    static int n, m;
    static char[][] arr;
    static int[][] ball = new int[2][2]; // 구슬 좌표
    static int[] end = new int[2]; // 도착점 위치
    static boolean success = false; // 성공 여부
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int min = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i=0; i<n; i++) {
            String input = br.readLine();

            for (int j=0; j < m; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] == 'R') {
                    ball[0] = new int[] {i, j};
                } else if (arr[i][j] == 'B') {
                    ball[1] = new int[] {i, j};
                } else if (arr[i][j] == 'O') {
                    end = new int[] {i, j};
                }
            }
        }

        if (search(0)) {
            bw.write(min + "");
        } else {
            bw.write(-1 + "");
        }



        bw.flush();
        bw.close();
        br.close();
    }
    /*
    이동 방향 결정
    - 4 방향 중 하나 선택 > 구슬 굴리기
    - 다음 이동 방향 결정 = search(cnt + 1)
    - 10 초과 > false 리턴
    */
    public static void search(int cnt) {
        if (cnt > 10) return;
        if (success) {
            min = Math.min(min, cnt);
        }

        if (cnt == 0) success = false;

        for (int d=0; d < 4; d++) {
            copy = new char[n][m];

            for (int i=0; i < n; i++) {
                copy[i] = Arrays.copyOf(arr[i], arr[i].length);
            }
            move(ball[0][0], ball[0][1], d, 'r');
            move(ball[1][0], ball[1][1], d, 'b');
            move(ball[0][0], ball[0][1], d, 'r');
            search(cnt + 1);
        }
    }

    /*
    구슬 이동 함수
    - type: 빨강 r/ 파랑 b
    */
    public static void move(int x, int y, int d, char type) {
        while(true) {
            int nx = curBall[0] + pos[d][0];
            int ny = curBall[1] + pos[d][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
            if (arr[nx][ny] == '#') break;
            if (type == 'r' && arr[nx][ny] == 'b') break;
            if (type == 'b' && arr[nx][ny] == 'r') break;


        }

    }

}
