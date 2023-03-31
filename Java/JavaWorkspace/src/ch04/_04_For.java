package ch04;

public class _04_For {
    public static void main(String[] args) {
        // For
        for ( int i = 0; i < 10 ; i++ ) {
            System.out.println("반복문: " + i);
        }

        // For 응용

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i);
            }
        }
        System.out.print("\n");

        for (int i = 0; i < 10; i += 2) {
            System.out.print(i);
        }
        
        System.out.print("\n");

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        System.out.println("합산 결과: "+sum);
    }
}
