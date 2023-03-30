package ch01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        // 정수 <-> 실수
        int score = 93;
        System.out.println(score);
        System.out.println((float) score); // 형변환
        System.out.println((double) score);

        float score_f = 93.5f;
        double score_d = 93.5;
        System.out.println((int) score_f);
        System.out.println((int) score_d);

        // 정수 + 실수 연산
        score = score + ((int) score_d);
        System.out.println(score);

        score_d = score + score_f;
        System.out.println(score_d);

        double convertedScoreDouble = score;
        // int -> long -> float -> double 자동 형변환

        int convertedScoreInt = (int) score_d;
        // double -> float -> long -> int 수동 형변환


        // 숫자 <-> 문자열
        String s1 = String.valueOf(93);  
        s1 = Integer.toString(93); // 정수를 문자열로 변환
        System.out.println(s1);

        String s2 = String.valueOf(98.8);
        s2 = Double.toString(98.8);

        int i = Integer.parseInt(s1);
        System.out.println(i);
        double d = Double.parseDouble("988.8");
        System.out.println(d);
        
        // int error = Integer.parseInt("자바") // Error
    }   
}
