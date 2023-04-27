package base.ch01;

/*
 * 자료형
 * int, long, float, double, char, String, boolean
 */

public class _03_Variables {
    public static void main(String[] args) {
        // 문자형 변수
        String name; 
        name = "홍길동";
        // String name = "홍길동";

        // 정수형 변수
        int hour = 15;

        System.out.println(name + "님 배송이 시작됩니다. " + hour + "시에 방문 예정입니다.");
        System.out.println(name + "님 배송이 완료되었습니다.");

        // 실수형 변수
        double score = 90.5;
        // 문자 변수
        char grade = 'A';

        name = "송송송";

        System.out.println(name + "님의 평균 점수는 " + score + "입니다.");
        System.out.println("학점은 " + grade + " 입니다.");

        // Boolean
        boolean pass = true;
        System.out.println(name + "님의 시험 합격 여부는? "+ pass);

        double d = 3.1456789;
        float f = 3.1456789F; // or 3.14f
        System.out.println(d);
        System.out.println(f);

        // int i = 1000000000000; // Error (21억 미만)
        long li = 1000000000000L; // or 1000000000l
        li = 1_000_000_000_000L;
        System.out.println(li);
    }
}
