/*
화살표 함수
- 인자 arg1, arg2, .. argN를 받는 func
- 화살표 우측 표현식을 계산하고 계산 결과를 반환한다.
*/
let func = (arg1, arg2, .. argN) => expression;
let func = function (arg1, arg2, .. argN) {
    return expression;
}

let sum = (a, b) => a + b;
alert(sum(1,2));

// 인수가 하나인 경우, 괄호 생략 가능
let double = n => n * 2;
alert(double(3)); // 6

// 인수가 하나도 없는 경우, 괄호 생략 불가능
let func = () => alert("hello")
func();

// expression이 여러줄 인 경우
// 중괄호 사용, 반드시 return으로 리턴값 명시
let sum = (a, b) => {  
    let result = a + b;
    return result; 
};

alert( sum(1, 2) ); // 3

// HW1
function ask(question, yes, no) {
    if (confirm(question)) yes()
    else no();
}

ask(confirm("Agree?", () => alert("Yes"), () => alert("No")));