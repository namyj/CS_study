package ch05;

public class _04_MultiArrayLoop {
    public static void main(String[] args) {
        String[][] arr = new String[10][15];
        String[] eng = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = eng[i] + (j+1);
                System.out.print(arr[i][j] + " "); 
            }
            System.out.println();
        }
        
        // 구매
        arr[7][8] = "__";
        arr[7][9] = "___";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " "); 
            }
            System.out.println();
        }
    }
}
