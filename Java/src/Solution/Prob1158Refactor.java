package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob1158Refactor {
    public static int n, k;
    public static LinkedList<Integer> list = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.offer(i); // 리스트 마지막에 원소 추가
        }

        sb.append("<");

        while (list.size() > 1) {
            for (int i = 0; i < k - 1 ; i++) { // 원형 리스트 - 앞의 원소를 뒤에 추가
                list.offer(list.poll()); // list.poll() - 리스트의 첫번째 요소 반환하며 제거
            }

            sb.append(list.poll()).append(", ");
        }

        sb.append(list.poll()).append(">"); // 마지막 원소 추가
        System.out.println(sb);
    }
}
