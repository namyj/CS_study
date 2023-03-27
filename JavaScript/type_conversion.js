// 명시적 형변환 - 문자열
let value = true;
alert(`value ${value} type ${typeof value}`);

value = String(value);
alert(`value ${value} type ${typeof value}`);

// 명시적 형변환 - 숫자
let str = "123";
alert(`value ${str} type ${typeof str}`);

str = Number(str);
alert(`value ${str} type ${typeof str}`);

/*
Number(undefined) -> NaN
Number(null) -> 0
Number(true) -> 1, Number(false) -> 0
Number(string) -> Number
*/

alert(Number("   123  ")) // 문자열 처음과 끝 공백 제거
alert(Number("123z")) // 변환 실패 -> NaN
alert(Number(true)) // 1
alert(Number(false)) // 0

// 명시적 변환 - 불린
/* 
Boolean( 0, null, undefined, NaN, "" ) -> flase
Boolean( 그 외 ) -> true
*/
alert(Boolean(1)) // true
alert(Boolean(0)) // false
alert(Boolean("string")) // 문자열 -> true
alert(Boolean(" ")) // 공백 포함 문자열 -> true
alert(Boolean("")) // 빈 문자열 -> false

