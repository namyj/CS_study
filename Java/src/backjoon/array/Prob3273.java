package backjoon.array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 접근법
 * - 이중 for 문, 두 원소끼리 더하기 > 시간 초과
 * - InputStream, ... 등 사용 > 시간 초과
 * - 투 포인터 & Arrays.sort 사용 > 정답
 *   - left, right 원소의 합이 x 보다 크/작다면 더하는 범위를 줄이는 방법
 *
 * 투 포인터 사용법
 * - 정수 배열 arr에 입력 저장
 * - arr 오름 차순 정렬
 * - 왼쪽 원소 포인터 left, 오른쪽 원소 포인턴 right 생성 (left = 0, right = len - 1)
 * - 포인터 이동하며 sum = arr[left] + arr[right] 체크
 *  - sum == x > result +1
 *  - sum > x > right - 1
 *  - sum < x > left + 1
 */
public class Prob3273 {
    public void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String[] inputs = br.readLine().split(" ");
        int xVal = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < inputs.length; i++) {
            for (int j = i; j < inputs.length; j++) {
                if (Integer.parseInt(inputs[i]) + Integer.parseInt(inputs[j]) == xVal )
                    cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        int result = 0, sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력
        int nVal = Integer.parseInt(br.readLine());
        int[] arr = new int[nVal];
        int left = 0, right = arr.length - 1;

        // 참고) 공백으로 구분된 정수 리스트 입력 방법
        // StringTokenizer로 공백을 구분자로 토큰별 입력 받음 > 한 토큰씩 읽어서 Integer.parseInt()
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nVal; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int xVal = Integer.parseInt(br.readLine());

        // 2. 입력 배열 정렬
        Arrays.sort(arr); // 라이브러리 사용
        // 버블 정렬 사용시 시간초과
        // for (int i = 0; i < arr.length - 1; i++) {
        //     for (int j = i+1; j < arr.length; j++) {
        //         if (arr[i] > arr[j] ) {
        //             int tmp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = tmp;
        //         }
        //     }
        // }
        
        // 3. result 구하기
        while (left < right) {
            if (arr[left] + arr[right] == xVal) { // case1
                result++;
                left++;
                right--;
            } else if (arr[left] + arr[right] > xVal) { // case2
                right--;
            } else { // case3
                left++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
/**
 * 주의
 * - 사용자가 숫자를 입력 후 enter 입력
 * - Scanner.nextInt() 숫자만 입력받고, 개행문자는 제거하지 않고 남겨 둠
 * - 남겨진 개행문자를 다음 Scanner.nextLine()이 입력으로 처리
 * > ["", "5", ... ] 이런 식으로 입력받게 됨
 * 해결 방법
 * - Scanner.nextInt 후 Scanner.nextLine 전에 Scanner.nextLine 한번 더 사용 (개행 문자 읽도록)
 */