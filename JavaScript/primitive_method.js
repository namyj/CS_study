/*
원시형
- 문자, 숫자, bigint, 불린, 심볼, null, undefined

객체
- 대괄호 {} 안에 프로퍼티, 메소드를 저장할 수 있음
*/

/*
원시 래퍼 객체 (object wrapper)
- String,Number,Boolean, Symbol

원시형에서 메소드 호출
1. object wrapper 객체 생성
2. 메소드 실행, 결과 반환
3. wrapper 객체 삭제
*/

// 주의) null, undefined는 wrapper 객체, 메서드 없음

// HW1
let str = "Hello";

str.test = 5; // (*)

alert(str.test); // undefined
// 프로퍼티 접근시 wrapper 객체 생성 -> 객체 삭제 -> 이후 해당 프로퍼티에 접근할 수 없음