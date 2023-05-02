package backjoon.stack;

/**
 * 출력: 수의 합
 * 조건
 * - 0 > 가장 최근에 쓴 수 삭제
 * - 그 외 정수 > 스택에 넣기
 *
 * 접근법
 * - java.util.Stack 활용
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Prob10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        int result = 0;

        for (int i=0; i < k; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if (inputNum == 0) {
                stack.pop();
            } else {
                stack.push(inputNum);
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}