package base.ch05;

public class _02_ArrayLoop {
    public static void main(String[] args) {
        String[] menus = {"아아메", "라떼", "카푸치노"};

        // enhanced for (for-each) 반복문
        for (String coffee : menus) {
            System.out.println(coffee);
        }
    }
}
