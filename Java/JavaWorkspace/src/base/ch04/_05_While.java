package base.ch04;

public class _05_While {
    public static void main(String[] args) {
        // while
        int d = 25;
        int move = 0;
        while (move < d) {
            System.out.println("현재 이동 거리: "+ move);
            move += 3;
        }
        System.out.println("while out");

        // do while
        // 무조건 한번은 실행
        d = 25;
        move = 0;
        int h = 25;
        do {
            System.out.println("현재 이동 거리: "+move);
            move += h;
        } while (move < d);
        System.out.println("도착 move: "+ move);
    }   
}
