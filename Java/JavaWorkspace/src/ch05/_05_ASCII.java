package ch05;

// 아스키 코드 (미국 표준 코드)
public class _05_ASCII {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println(c);
        System.out.println((int)c);
        
        c++;
        System.out.println(c);
        System.out.println((int)c);

        // 좌석표
        String[][] arr = new String[10][15];
        char eng = 'A';

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(eng) + (j+1); // 문자 -> 문자열 변환 필요
                System.out.print(arr[i][j] + " "); 
            }
            eng++;
            System.out.println();
        }
    }
}
