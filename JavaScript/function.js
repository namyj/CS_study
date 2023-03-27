// // 함수 선언문
// // param1, param2는 함수 호출시 전달 되는 값을 복사해두는 지역 변수
// function func(param1, param2) {
//     alert("function block");
// }
// // 함수 호출
// let op1 =0 , op2 = 0;
// func(op1, op2)

// // 함수 호출시 매개변수의 개수보다 적은 수의 인자를 전달 -> 나머지는 undefined
// // = 으로 매개변수에 default 할당 가능
// // 인자로 값을 전달하지 않거나, undefined 를 전달 -> default value 할당
// function showMessage(from, text = "no text given") {
//     alert( from + ": " + text );
// }

// function showMessage(from, text) {
//     // 방법1
//     if (text == undefined) { // text가 undefined인 경우
//       text = 'no text given';
//     }
//     // 방법2
//     // text = text || 'no text given';

//     // 방법3
//     // text = text ?? 'no text given';
//     alert( from + ": " + text );
// }

// showMessage("Ann", "Tom"); // text = "Tom"
// showMessage("Ann"); // text = "no text given"
// showMessage("Ann", null); // text = "no text given"
// showMessage("Ann", undefined); // text = "no text given"

// // default value로 함수 설정 가능
// function showMessage(from, text = anotherFunction()) {
//     // anotherFunction()은 text값이 없을 때만 호출 -> anotherFunction()의 반환 값이 text의 값이 됨
// }

// // return value
// function checkAge(age) {
//     if (age >= 18) return true;
//     else return confirm('보호자의 동의를 받으셨나요?');
// }

// let age = prompt('나이를 알려주세요', 18);

// if ( checkAge(age) ) alert( '접속 허용' );
// else alert( '접속 차단' );

// // return; 또는 return 문이 없는 함수
// // undefined 반환
// function doNothing() { /* empty */ }
// alert( doNothing() === undefined ); // true

// function doNothing() {
//     return; // undefined 반환
// }
// alert( doNothing() === undefined ); // true

// // 주의) 자바스크립트는 return 문 긑에 자동으로 ; 을 삽입한다. 
// // 따라서 리턴값 식이 길다고 새로운 줄을 추가하면 안된다. 
// // 여러줄로 작성하고 싶은 경우, 괄호 사용

// // HW1
// function checkAge(age) {
//     // return (age > 18) ? true : confirm("보호자 동의 여부");
//     return ( age > 18 ) || confirm("보호자 동의 여부");
// }

// HW2
function min(param1, param2){
    return (param1 < param2) ? param1 : param2;
}

// HW3
let num1 = prompt("Insert Number", 0);
let num2 = prompt("Insert Number", 0);
function pow(param1, param2) {
    if (param2 < 1) {
        alert("error: 1 이상 자연수 입력");
    } else {
        return param1 ** param2;
    }
}
pow(num1, num2);