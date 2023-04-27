package base.ch04;

// switch case
/*
 * 명확한 case 존재 -> switch case
 * 값의 범위        -> if else
 */
public class _03_Switch {
    public static void main(String[] args) {
        int rank = 1;

        if (rank ==1 ) {
            System.out.println("1");
        } else if (rank == 2) {
            System.out.println('2');
        } else if (rank == 3) {
            System.out.println("3");
        } else {
            System.out.println("4");
        }

        // Or
        rank = 2;
        switch (rank) {
            case 1:
                System.out.println("rank 1");
                break;
            case 2:
            case 3:
                System.out.println("rank 2 3");
                break;
            default: 
                System.out.println("defaul 문장");
            // default 문자 없어도 에러 발생 X
        }
    }
}
