package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 솔루션 - 보드 내 CCTV 방향의 가능한 모든 조합에 대해서 탐색 > 최소값 반환
 * - CCTV 클래스 생성해서 MAP을 입력받을 때 CCTV 정보를 저장해둔다.
 * - cctv 방향 선택 및 탐색 > DFS
 * - 안접 칸 방문 > BFS
 *
 * [참고: https://minhamina.tistory.com/134]
 */

class CCTV {
    int num;
    int x;
    int y;

    CCTV(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

public class Prob15683 {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static ArrayList<CCTV> cctvList;
    static int[] cctvDir; // CCTV 방향 저장
    static int minCnt;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        minCnt = N*M;
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && map[i][j] != 6)
                    cctvList.add(new CCTV(map[i][j], i, j));
            }
        }

        cctvDir = new int[cctvList.size()];
        func(0, cctvList.size());

        System.out.println(minCnt);
    }

    /**
     * 1. CCTV 개수만큼 상하좌우 방향을 선택
     * 2. 방향 선택 완료 > 사각지대를 구한다
     * @param depth
     * @param r
     */
    public static void func(int depth, int r) {
        if (depth == r) {
            // Copy map > copyMap
            copyMap = new int[N][M];
            for (int i = 0; i < map.length; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
            }

            for (int i = 0; i < cctvList.size(); i++) {
                direction(cctvList.get(i), cctvDir[i]);
            }

            getBlindSpot();
            return;
        }

        // CCTV 방향 선택
        for (int i = 0; i < 4; i++) {
            cctvDir[depth] = i;
            func(depth + 1, r);
        }
    }

    public static void direction(CCTV cctv, int d) {
        int cctvNum = cctv.num;

        switch (cctvNum) {
            case 1:
                watch(cctv, d);
                break;
            case 2:
                if(d == 0 || d == 2) {
                    watch(cctv, 0); watch(cctv, 2); // 상하
                } else {
                    watch(cctv, 1); watch(cctv, 3); // 좌우
                }
                break;
            case 3:
                if(d == 0) {
                    watch(cctv, 0); // 상우
                    watch(cctv, 1);
                } else if(d == 1) {
                    watch(cctv, 1); // 우하
                    watch(cctv, 2);
                } else if(d == 2) {
                    watch(cctv, 2); // 하좌
                    watch(cctv, 3);
                } else if(d == 3) {
                    watch(cctv, 0); // 좌상
                    watch(cctv, 3);
                }
                break;
            case 4:
                if(d == 0) {
                    watch(cctv, 0); // 좌상우
                    watch(cctv, 1);
                    watch(cctv, 3);
                } else if(d == 1) {
                    watch(cctv, 0); // 상우하
                    watch(cctv, 1);
                    watch(cctv, 2);
                } else if(d == 2) {
                    watch(cctv, 1); // 좌하우
                    watch(cctv, 2);
                    watch(cctv, 3);
                } else if(d == 3) {
                    watch(cctv, 0); // 상좌하
                    watch(cctv, 2);
                    watch(cctv, 3);
                }
                break;
            default:
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
        }
    }

    // BFS로 CCTV가 해당 방향에서 볼 수 있는 모든 칸을 확인
    public static void watch(CCTV cctv, int d) {
        Queue<CCTV> q = new LinkedList<>();
        boolean[][] isUsed = new boolean[N][M];

        q.add(cctv);
        isUsed[cctv.x][cctv.y] = true;

        while (!q.isEmpty()) {
            int nx = q.peek().x + dx[d];
            int ny = q.poll().y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6) break;

            if (copyMap[nx][ny] == 0) {
                copyMap[nx][ny] = -1;
                q.add(new CCTV(cctv.num, nx, ny));
            } else { // 다른 CCTV 존재, 이미 감시한 칸
                q.add(new CCTV(cctv.num, nx, ny));
            }
        }
    }

    public static void getBlindSpot() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        minCnt = Math.min(minCnt, cnt);
    }
}
