package techit;
import java.util.Scanner;

// 하-3 배열 내 최대값 구하기
public class _01_01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputs = sc.nextLine();
        int max = Integer.MIN_VALUE;

        for (String num : inputs.split(" ")) {
            if (Integer.parseInt(num) > max) {
                max = Integer.parseInt(num);
            }
        }

        System.out.println("최대값:"+max);
    }
}
