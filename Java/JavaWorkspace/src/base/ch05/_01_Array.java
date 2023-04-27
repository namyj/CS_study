package base.ch05;

// 배열 Array
public class _01_Array {
    public static void main(String[] args) {
        // 배열 선언
        // 방법 1
        String[] arr1 = new String[4]; // 크기 4 String 배열 생성
        
        // 방법 2
        String arr2[] = new String[4];

        arr1[0] = "아메리카노";
        arr1[1] = "카페모카";
        arr1[2] = "라떼";
        arr1[3] = "카푸치노";

        // 방법 3
        String[] arr3 = new String[] {"아메리카노", "카페모카", "라떼"};

        // 방법4
        String [] arr4 = {"아메리카노", "카페모카", "라떼"};

        arr1[2] = "에스프레소";
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Menu: " + arr1[i]);
        }
    }
}
