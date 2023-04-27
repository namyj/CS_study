package base.ch02;

// 산술 연산자
public class _01_Operator1 {
    public static void main(String[] args) {
        System.out.println(4+2);
        System.out.println(4-2);
        System.out.println(4*2);
        System.out.println(4/2);
        System.out.println(5/2); // 2
        System.out.println(2/4); // 0, 소수점 버려지고 몫만 남음
        System.out.println(4%2); // 0, 나머지 연산

        int a = 20;
        int b = 10;
        int c;

        c = a+b;
        System.out.println(c);
        c = a%b;
        System.out.println(c);
        c = a/b;
        System.out.println(c);

        // 증감 연산
        // ++, --
        int val;
        val = 10;
        System.out.println(val);

        // val++; // val 사용 후 val+1
        // ++val; // val+1 후 val 사용 

        // 10 11 11
        System.out.println(val);
        System.out.println(++val);
        System.out.println(val);


        // 10 10 11
        val = 10;
        System.out.println(val); 
        System.out.println(val++);
        System.out.println(val);

        // ex
        int waiting = 0;
        System.out.println("대기 인원: " + waiting++);
        System.out.println("총 대기 인원: " + waiting);
    }   
}
