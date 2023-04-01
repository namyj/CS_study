package ch05;

// 다차원 배열
public class _03_MultiArray {
    public static void main(String[] args) {
        String[][] multiArray1 = new String[4][5]; // multiArray1 초기화 필요
        String[][] multiArray2 = new String[][] {
            {"A1", "A2", "A3", "A4", "A5"}, 
            {"B1", "B2", "B3", "B4", "B5"}, 
            {"C1", "C2", "C3", "C4", "C5"}, 
            {"D1", "D2", "D3", "D4", "D5"}
        };
        String[][] multiArray3 = { 
            { "A1", "A2", "A3", "A4", "A5" }, 
            { "B1", "B2", "B3", "B4", "B5" },
            { "C1", "C2", "C3", "C4", "C5" }, 
            { "D1", "D2", "D3", "D4", "D5" }
        };

        // 다차원 배열 순회
        for (int i = 0; i < multiArray3.length; i++) {
            for (int j = 0; j < multiArray3[i].length; j++) {
                System.out.print(multiArray3[i][j] + " ");
            }
            System.out.println();
        }

        String[][] seats = {
            {"A1", "A2", "A3"},
            {"B1", "B2"}
        };

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }

        // 3차원 배열 
        String[][][] marray = new String[][][] {
            {{}, {}, {}},
            {{}, {}, {}},
            {{}, {}, {}}
        };
    }
}
