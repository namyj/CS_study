package backjoon.recursion;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 접근법
 * - n > 1 일 때 4 분할로 나눠서 방문
 * - n==1 이면, (x,y) -> (x,y+1) -> (x+1,y) -> (x+1,y+1) 방문
 * > 시간 초과
 *
 * 시간 초과 이유?
 * - 내 풀이법은 모든 칸을 방문하고 난 뒤 결과를 출력
 * - N의 최대값은 15로, 방문해야하는 칸 수는 2^15 * 2^15 = 10 억 이상
 * - CPU의 평균 연산량을 보수적으로 추정하면 1초에 약 1억번이다,
 *  이 문제의 제한시간이 0.5초이므로, 10억 >> 5000만이 되어서 시간초과가 납니다.
 */
public class Prob1074 {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int r;
    public static int c;
    public static int[][] pos = {{0,0}, {0,1},{1,0},{1,1}}; // 방문 순서

    public static int cnt = -1; // 결과

    // 방법 1 > 시간초과
    // x, y : 시작점, n : 원소 개수 (2의 몇 제곱인지)
    public static void visitZ(int x, int y, int n) throws IOException {
        int nx; int ny;

        if (n==1) { // 방문
            for (int i=0; i < pos.length; i++) {
                cnt++;
                nx = x + pos[i][0];
                ny = y + pos[i][1];
                if (nx == r && ny == c) {
                    bw.write(cnt+"");
                }
            }
            return;
        }

        // 분할 방문
        int mid = (int) Math.pow(2, n-1);
        visitZ(x, y, n-1);
        visitZ(x, y + mid, n-1);
        visitZ(x + mid, y, n-1);
        visitZ(x + mid, y + mid, n-1);
    }

    // 방법2
    // 전체 탐색하면 시간 초과 > r 과 c를 포함하는 것만 방문
    // 이전 사분면들의 칸 수를 cnt에 더하고 나서 r,c를 포함한 사분면 방문
    public static void solution(int x, int y, int n) throws IOException {

        if (n==1) { // 방문
            int nx; int ny;

            for (int i=0; i < pos.length; i++) {
                cnt++;
                nx = x + pos[i][0];
                ny = y + pos[i][1];

                if (nx == r && ny == c) {
                    bw.write(cnt +"");
                }
            }
            return;
        }

        // 분할 방문
        // R과 C 를 포함하는 것만 방문
        int mid = (int) Math.pow(2, n-1);

        if (r >= x && r < x+mid && c >= y && c < y+mid ) {
            visitZ(x, y, n-1);
        }

        cnt += mid*mid;
        if (r >= x && r < x+mid && c >= y+mid ) {
            visitZ(x, y + mid, n-1);
        }

        cnt += mid*mid;
        if (r >= x+mid && c >= y && c < y+mid ) {
            visitZ(x + mid, y, n-1);
        }

        cnt += mid*mid;
        if (r >= x+mid && c >= y+mid ) {
            visitZ(x + mid, y + mid, n-1);
        }
    }

    // 바킹독 솔루션
    public static int func(int r, int c, int n) {
        if (n==0) return 0;

        int mid = (n-1)/2;
        if (r < mid && c < mid) return func(r, c, n-1); // 1사분면
        if (r < mid && c >= mid) return mid*mid + func(r, c-mid, n-1);
        if (r >= mid && c < mid) return 2*mid*mid + func(r-mid, c, n-1);
        return 3*mid*mid + func(r-mid, c-mid, n-1);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solution(0, 0, n);

        bw.flush();
        bw.close();
        br.close();

    }
}