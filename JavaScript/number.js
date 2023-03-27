// // Number
// // e = 10
// let num1 = 1e3; // 1000 
// let num2 = 1e-3; // 0.001

// /*
// 진법 변경
// num.toString(base)
// - num을 base 진법으로 변경 후 문자형으로 반환
// - base: 2~36
// */
// let num = 255;
// alert(num.toString(16));
// alert(num.toString(2));
// alert(1234..toString(2)); // 숫자를 대상으로 메소드를 호출할 경우, .. 점 두개 사용

// // 소수 어림수
// let num3 = 1.234;
// alert(Math.floor(num3)); // 소수점 첫째 자리 버림
// alert(Math.ceil(num3)); // 소수점 첫째 자리 올림
// alert(Math.round(num3)); // 소수점 첫째 자리 반올림
// alert(Math.trunc(num3)); // 소수부 무시

// // 소수점 첫째 자리가 아닌 어림수를 원하는 경우
// let num3 = 1.234;
// // case1) 곱하고 나누기
// alert(Math.floor(num3 * 100)/100) // 1.23
// // case2) toFixed 로 원하는 자리의 어림수 구하고 숫자형 변환
// alert(+num3.toFixed(2)); // 1.23
// // 주의) 소수부 길이가 toFixed 인수보다 작으면 숫자 뒤에 0 이 붙음
// alert(num3.toFixed(5)); // 1.23400

// /*
// 부정확한 계산
// - 컴퓨터는 이진법으로 숫자를 기록
// - 0.1, 0.2 처럼 이진법으로 표현하면 무한 소수가 되는 숫자를 포함한 연산은 부정확할 수 있음
// */
// // 해결- 어림수 만들기
// let sum = 0.1 + 0.2;
// alert( +sum.toFixed(2) ); // 0.30

// // 두 종류의 0
// // 0 과 -0

// // isNaN
// // 인자가 NaN 인지 확인
// alert(isNaN(NaN));
// alert(isNaN(123));

// // isFinite
// // 인자가 finite 인지 확인 (NaN/Infinity/-Infinity 가 아니면 true)
// alert(isFinite("15"));
// alert(isFinite("str")) // str 형변환 -> NaN -> false
// alert(isFinite(Infinity))

// // Object.is
// // === 처럼 값을 비교할때 사용하는 내장 메서드
// alert(Object.is(NaN, NaN)) // true (예외)
// alert(NaN === NaN) // false, NaN은 자기 자신을 포함한 모든 것들과 비교했을때 false
// alert(Object.is(-0,0)); // false

// // parseInt
// // 문자열의 맨 첫번째부터 정수부분만 읽음
// // 읽다 에러가 발생하면, 지금까지 읽은 숫자만 반환
// alert( parseInt('100px') ); // 100
// alert( parseInt('12.3') ); // 12

// // parseFloat
// // 문자열의 맨 첫번째부터 소수부분만 읽음
// alert( parseFloat('12.5em') ); // 12.5
// alert(parseFloat("12*.1"));
// alert( parseFloat('12.3.4') ); // 12.3

// // 랜덤 함수
// // 0~1 사이 랜덤값 반환 (1 제외)
// alert(Math.random())

// // max vs min 반환
// alert(Math.max(3, 5, -10, 0, 1)); // 5
// alert(Math.min(3, 5, -10, 0, 1)); // -10

// // 거듭제곱
// alert(Math.pow(2,3)); // 8

// // HW1
// let num1 = +prompt('Insert value', 0);
// let num2 = +prompt('Insert value', 0);

// alert(num1 + num2);

// // HW2
// alert( 1.35.toFixed(1) );
// alert( 6.35.toFixed(1) ); // 2진법으로 무한 소수 -> 정밀도 손실 발생

// // 해결
// alert( Math.round(6.35 * 10)/10);

// HW3
function readNumber() {
    let num;
    
    do {
        num = prompt("Insert number", 0);
        // 빈문자열, null -> 숫자형으로 0
        // 따라서 사용자가 아무 값도 입력 않거나, 취소를 누르면 반복문을 빠져나옴
    } while(!isFinite(num));

    if (num === null || num === '') return null;
    return +num;
};

// HW4
function random(min, max) {
    let value;

    do {
        value = Math.random()*10;
    } while( value < min && value >= max)
    
    return value;
};

// 해결
// 0~1 사이 난수에 max-min을 곱하면, 가능한 격차가 0~1 사이에서 0~max-min 사이 값이 된다
function random(min, max) {
    return min + Math.random() * (max - min);
};