package lecture;

public class AlphaToInteger {
    // 숫자로만 이루어진 value 문자열이 입력된다고 가정
    // 1. 각 글자를 숫자 데이텉로 해석
    // 2. 48을 빼주면 숫자가 된다.
    private int atoi(String value) {
        int result = 0;
        // TODO 문자열을 한글자(한 자리)씩 확인
        boolean negative = false;
        int i=0;

        // 첫 번째 문자가 '-' 인지
        if (value.charAt(i) == '-') {
            negative = true;
            i++;
        }

        for (; i < value.length() ; i++) {
            // TODO 자릿수 변환
            result *= 10;
            // TODO 글자를 숫자로 변환
            result += value.charAt(i) - '0';
        }

        if (negative) result *= -1;

        return result;
    }

    private int atoiMySolution(String value) {
        int result = 0;
        int ten = 1;
        // TODO 문자열을 한글자(한 자리)씩 확인
        // TODO 자릿수 변환
        // TODO 글자를 숫자로 변환
        for (int i = value.length()-1; i >= 0 ; i--) {
            char tmp = value.charAt(i);
            result += (tmp - 48) * ten;
            ten *= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        AlphaToInteger atoi = new AlphaToInteger();
        System.out.println(atoi.atoi("12345"));
        System.out.println(atoi.atoi("-4291"));
    }
}
