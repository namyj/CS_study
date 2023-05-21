package backjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 접근법
 * - 백트래킹
 * 참고 : https://jellyinghead.tistory.com/53
 */
public class Prob12100_solution {
    static int answer = 0;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        search(0);
        System.out.println(answer);
    }

    /**
     * 
     * @param cnt 이동 횟수
     */
    public static void search(int cnt) {
        // 5번 이동 완료 > 블록 중 최대 값 찾기
        if (cnt == 5) {
            findMax();
            return;
        }

        // 원본 배열 백업
        int copy[][] = new int[N][N];
        for (int i = 0; i < N ; i++)
            copy[i] = map[i].clone();

        // 방향 설정, 이동 > 다음 이동 횟수 탐색
        for (int d = 0; d < 4; d++) {
            move(d);
            search(cnt++);

            for (int i = 0; i < N ; i++)
                map[i] = copy[i].clone();
        }
    }
    
    // 정한 방향으로 블록 이동
    // idx = 값을 넣을 위치, block : 최근 블록의 값

    /**
     * 정한 방향으로 블록 이동
     * - idx : 값을 넣을 위치, block : 최근 블록의 값
     *
     * 바깥 for 문 : 이동시 변하지 않는 좌표
     * 안쪽 for 문 : 이동시 변하는 좌표
     * ex) 위로 벽돌 몰기 > 바깥 for 문 : y 좌표, 안쪽 for 문 : x 좌표
     *
     * 벽돌 합치기는 이동 방향에서부터 합쳐진다 > 이동 방향에 따라 시작 값이 달라져야함
     * ex) 위로 벽돌 몰기 = 위에서 부터 합치기 > i = 0, idx = 0
     *     오른쪽으로 벽돌 몰기 > i = 0, idx = n-1
     *
     * @param dir
     */
    public static void move(int dir) {
        switch (dir) {
            case 0: // 상
                for (int i = 0; i < N ; i++) {
                    int idx = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] != 0) { // 블럭 칸인 경우
                            if (block == map[j][i]) { // 같은 블럭을 만났을 때 > 위 칸에 block*2 값 넣어주기
                                map[idx - 1][i] = block*2; 
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                // block과 idx를 swap
                                block = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;
            case 1: // 하
                for (int i = 0; i < N; i++) {
                    int idx = N-1;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] != 0) { // 블럭 칸인 경우
                            if (block == map[j][i]) { // 같은 블럭을 만났을 때 > 아래 칸에 block*2 값 넣어주기
                                map[idx + 1][i] = block*2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;
            case 2: // 좌
                for (int i = 0; i < N; i++) {
                    int idx = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] != 0) { // 블럭 칸인 경우
                            if (block == map[i][j]) { // 같은 블럭을 만났을 때 > 좌측 칸에 block*2 값 넣어주기
                                map[i][idx - 1] = block*2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;
            default: // 우
        }
    }
    
}
