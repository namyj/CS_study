package backjoon.base2;

import java.io.*;

/**
 * 조건
 * - 출력 시간 줄이기
 * 접근법
 * - InputStreamReader, OutputStreamWriter, BufferedReader, BufferedWriter 사용 > 시간 초과
 * - 버퍼에 각 케이스 결과를 저장 후 마지막에 출력하기 > 정답
 */
public class Prob15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tVal = Integer.parseInt(br.readLine());
        String[] inputs;

        for (int i = 0; i < tVal; i++) {
            inputs = br.readLine().split(" ");
            bw.write(String.valueOf(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
