package backjoon.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 접근법
 * - 백트래킹
 * 참고 : https://jellyinghead.tistory.com/53
 */

public class Prob12100_solution {

    static int n, answer, map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[n][n];
        StringTokenizer stz;
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }

        game(0);
        System.out.println(answer);
    }

    /**
     * 1. cnt < 5 인 경우,
     *   (시작 전) 원본 배열을 복사해 둔다 (백업용)
     *   1-1. 4 가지 방향 중 하나로 이동
     *   1-2. 다음 이동에 대해 탐색
     *   1-3. 탐색이 끝나면, 원본 배열 백업
     * 2. cnt >= 5 인 경우,
     *   map 내 숫자 중 max 찾기
     * @param cnt 이동 횟수
     */
    public static void game(int count) {
        if(count == 5) {
            findMax();
            return;
        }
        int copy[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            copy[i] = map[i].clone();

        for(int i = 0; i < 4; i++) {
            move(i);
            game(count+1);
            for(int a = 0; a < n; a++)
                map[a] = copy[a].clone();
        }
    }

    /**
     * 정한 방향에 따라 블록 이동
     * - idx : 값을 넣을 위치, block : 최근 블록의 값
     *
     * 바깥 for 문 : 이동시 고정할 좌표
     * 안쪽 for 문 : 이동 방향의 좌표
     * ex) 위로 벽돌 몰기 > 바깥 for 문 : y 좌표, 안쪽 for 문 : x 좌표
     *
     * 벽돌 합치기는 이동 방향에서부터 합쳐진다 > 이동 방향에 따라 시작 값이 달라져야함
     * ex) 위로 벽돌 몰기 = 위에서 부터 합치기 > i = 0, idx = 0
     *     오른쪽으로 벽돌 몰기 > i = 0, idx = n-1
     *     
     * 이전 블록의 값과 현재 블록의 값이 같은 경우
     * - idex -1 위치에 block * 2 넣어주기
     * - block = 0 초기화 (한 번 이동시 한 번만 합쳐진다)
     * - map[i][j] = 0 (해당 블럭이 이동했기 때문에)
     *
     * @param dir
     */
    public static void move(int dir) {
        switch(dir) {
            //위로 몰기
            case 0:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 1:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                answer = Math.max(answer, map[i][j]);
    }

}