package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackPostfixCalc {
    public static void main(String[] args) throws IOException {
        StackPostfixCalc stackPostfixCalc = new StackPostfixCalc();
        stackPostfixCalc.solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            // 1. 숫자 > stack push
            // token - '0' > 0과 token의 아스키 코드 값 차이로 int 변환
            if (Character.isDigit(token)) {
                stack.push(token-'0');
            }
            // 2. 숫자가 아닌 경우, stack에서 두 번 pop & 계산
            else {
                int num2 = stack.pop();
                int num1 = stack.pop();

                int ans = switch (token) {
                    case '-' -> num1 - num2;
                    case '+' -> num1 + num2;
                    case '/' -> num1 / num2;
                    case '*' -> num1 * num2;
                    default -> throw new RuntimeException("잘못된 연산자 입력");
                };

                stack.push(ans);
            }
        }

        if (stack.size() != 1) {
            System.out.println("잘못된 수식");
        } else {
            System.out.println(stack.pop());
        }
    }
}
