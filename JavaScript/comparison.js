let result = 5 > 4 ; // result = true

/*
문자열 비교
- 유니코드순 (사전 뒤쪽 문자열이 더 큼)
- 맨 앞 첫 문자부터 비교 시작 -> 글자간 비교가 끝날 때까지 비교
- 앞 글자는 모두 동일하고 길이만 다르다면, 긴 문자열이 더 크다
- 소문자 > 대문자 
 */

alert('z' > 'a') // true
alert('Bee' > 'Be') // true
alert('a' > 'A') // true

/*
서로 다른 형 사이 비교
- 숫자형으로 변환
*/
alert('2' > 1) // true
alert('01' == 1) // true
alert('01' > 1) // false
alert(true == 1) // true
alert(false == 0) // true

// 주의
let num1 = 0;
alert( Boolean(num1)); // 0 -> false

let num2 = "0";
alert( Boolean(num2)); // 길이가 1 이상인 문자열 -> true

alert(num1 == num2); // true

/*
일치 연산자
- === : strict == , 자료형의 동일 여부도 비교 (형변환 없이 값 비교)
- !== : strict != 
 */
alert(0 === false); // false
// 비교 연산자의 경우
alert(0 == false); // true
alert('' == false); // true
alert(' ' == false); // true (문자열을 숫자로 변환할 때는 앞뒤 공백을 제거하고 숫자로 변환하기 때문에)
alert(Number(' 1 0 ')) // NaN ('1 0'은 숫자로 변환 불가능)

/*
null 과 undefined 비교
- == : null과 undefined 를 동일하게 취급
- 그 외 비교 연산자, 산술 연산자 : null -> 0, undefined -> NaN 변환 
*/
alert(null === undefined) // false
alert(null == undefined) // true

// null vs 0
// == : 피연산자가 null, undefined 일때 형변환을 하지 않음 
alert(null > 0) // false, null -> 0 형변환
alert(null == 0) // false
alert(null >= 0) // true, null -> 0 형변환

// undefined 비교
// 피연산자가 NaN 인 경우, 비교 연산은 무조건 false 
alert(undefined > 0) // false, undefined -> NaN 변환
alert(undefined == 0) // false
alert(undefined < 0) // false, undefined -> NaN 변환

/**
주의!
- 비교연산자의 피연산자에 null, undefined 가 오지 않도록
 */

// HW1
5 > 4 // true
"apple" > "pineapple" // false
"2" > "12" // true, 두 피연산자가 문자열 -> 사전순으로 비교
undefined == null // true
undefined === null // false
null == "\n0\n" // false
null === +"\n0\n" // false