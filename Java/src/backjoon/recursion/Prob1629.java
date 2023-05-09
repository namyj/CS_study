package backjoon.recursion;

import java.io.*;
import java.util.*;
/**
 * 접근법
 * - 반복문 > 시간 초과 O(b)
 * - 재귀
 *      - base condition = b <= 1 일 때 a % b 반환
 *      - long val = mod(a, b/2, c)
 *      - 시간 복잡도 O(log b)
 *
 * 주의
 * - val = a * a 가 들어가는 경우 존재 > int overflow
 *  - val을 long으로 선언
 */
public class Prob1629 {
    // loop > 시간 초과
    public static int mod(int a, int b, int c) {
        while (b > 0) {
            a = (a * a) % c;
            b--;
        }
        return a;
    }


    public static long modRecursion(int a, int b, int c) {
        if (b == 1) return a %= c; //  base condition
        // return mod(a, b/2, c) * mod(a, b/2, c) % c; // 동일한 연산을 두번 수행 > 시간 초과 O(b)

        // 솔루션
        long val = mod(a, b/2, c);
        val = val * val % c;

        // b가 짝수 > val 반환
        // b가 홀수 > val 에 a를 한번 더 곱한 후 c로 나눈 나머지 반환
        // ex) b = 5, b/2 = 2 로 한번 더 곱해줘야함
        if (b%2 == 0) return val;
        return val * a % c;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(modRecursion(a, b, c));
    }
}