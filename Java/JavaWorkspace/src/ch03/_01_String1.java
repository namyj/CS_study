package ch03;

// 문자열
/*
 * 문자열 ""
 * 문자 ''
 */
public class _01_String1 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";
     
        // 문자열 길이
        System.out.println(s.length());
        
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        
        // 포함 관계
        System.out.println(s.contains("Java"));
        System.out.println(s.contains("java"));
        System.out.println(s.indexOf("Java")); // 시작 인덱스 반환
        System.out.println(s.indexOf("C+")); // -1 == 포함 X
        System.out.println(s.indexOf("and")); // 앞에서부터 검색
        System.out.println(s.lastIndexOf("and")); // 뒤에서부터 검색
        System.out.println(s.startsWith("I like")); // 해당 문자열로 시작하는지
        System.out.println(s.endsWith("ava")); // 해당 문자열로 끝나는지
        

        // Example
        String id = "121212-2111111";
        System.out.println(id.substring(0, id.indexOf("-")+2));
    }
}
