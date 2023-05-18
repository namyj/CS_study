package backjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 솔루션 참고: https://velog.io/@hoonze/%EB%B0%B1%EC%A4%80-18808-%EC%8A%A4%ED%8B%B0%EC%BB%A4-%EB%B6%99%EC%9D%B4%EA%B8%B0JAVA
 */
public class Prob18808_solution {
    static int N, M, K, ans = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 스티커 입력 받기 > 바로 map 에 붙이기
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            findLocation(sticker);
        }
        System.out.println(ans);
    }

    // 스티커를 방향을 회전하면서 붙여보기
    public static void findLocation(int[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int d = 0; d < 4; d++) {
            if (d != 0) sticker = rotate(sticker, r, c);

            r = sticker.length;
            c = sticker[0].length;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M ; j++) {
                    if (i + r > N || j + c > M) break; // 해당 위치에서 이미 스티커가 벗어남 > 다른 위치 찾기

                    if (putOn(i, j, r, c, sticker)) {
                        return;
                    }
                }
            }
        }
    }

    // (x,y)를 시작점으로 스티커 붙이기 > 가능/불가능 판단
    // 주의: map은 (0,0) 시작점이기 때문에 sticker에선 [i-x][j-y] 로 반영
    public static boolean putOn(int x, int y, int r, int c, int[][] sticker) {
        for (int i = x; i < x+r; i++) {
            for (int j = y; j < y+c; j++) {
                if (map[i][j] == 1 && sticker[i-x][j-y] == 1) // 스티커를 붙여야하는 위치에 1 > 불가능
                    return false;
            }
        }

        // 스티커 붙이기 가능

        // map에 스티커 반영 > 1 로 변환과 동시에 칸 수 1 증가
        for (int i = x; i < x+r; i++) {
            for (int j = y; j < y + c; j++) {
                if (sticker[i-x][j-y] == 1) {
                    map[i][j] = 1;
                    ans++;
                }
            }
        }

        return true;
    }

    public static int[][] rotate(int[][] sticker, int r, int c) {
        int[][] newSticker = new int[c][r];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                newSticker[j][r - i - 1] = sticker[i][j];

        return newSticker;
    }
}
