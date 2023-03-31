package ch04;

// 이중 반복문
public class _06_NestedLoop {
    public static void main(String[] args) {
        // 좌측 피라미드
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        // 우측 피라미드
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5-(i+1); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Example 구구단

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
            System.out.println();
        }

        // 중단 Break
        for (int i = 0; i >= 0; i++) {
            System.out.println(i);
            if (i >= 10)
                break;
        }

        // Example - 주차 요금 계산
        int won = 0;
        int hour = 10;
        // int car = 2; // car 종류 1, 2: 장애인, 경차 / 3 : 일반

        boolean isSmall = true;
        boolean withDisablePerson = true;

        won = hour * 4000;

        if (won > 30000) {
            won = 30000;
        }
        
        // switch (car) {
        //     case 1:
        //     case 2:
        //         won /= 2;
        //         break;
        //     default:
        //         break;
        // }

        if (isSmall || withDisablePerson) {
            won /= 2;
        }

        
        System.out.println("주차 요금: "+won);



        

    }
}
