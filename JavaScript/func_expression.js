// 함수 표현식
// JS는 함수를 특별한 종류의 값으로 취급
// case1: 함수 선언식
function func1() {
    alert("func1");
}

// case2: 함수 표현식 
let func2 = function() {
    alert("func2");
};

alert(func2); // 함수 코드를 출력
func2() // 함수 호출

// 함수 복사
let copy_func1 = func1;
let copy_func2 = func2;

// callback function
function ask(q, yes, no) {
    // 콜백 함수: yes, no
    if (confirm(q)) yes();
    else no();
} 
function showYes() {
    alert("Yes");
}
function showNo() {
    alert("No");
}
ask("Agree?", showYes, showNo);

function ask(question, yes, no) {
    if (confirm(question)) yes()
    else no();
}

ask(
"동의하십니까?",
function() { alert("Yes"); }, // anonymous func
function() { alert("No"); }
);

/*
함수 선언식 vs 함수 표현식
- 함수 표현식은 실제 실행 흐름이 해당 함수에 도달했을때 함수를 생성, 따라서 해당 코드가 실행된 이후 호출 가능 
- 함수 선언문은 함수 선언문의 정의되기 전에 호출할 수 있음
- scope 차이: 함수 표현식으로 블록 밖에서도 함수 호출 가능, 함수 선언문은 선언된 블록 내에서만 호출 가능
*/
sayHi("John"); // 정상 동작, Hello, John
function sayHi(name) {
  alert( `Hello, ${name}` );
}

sayHi("John"); // error
let sayHi = function(name) {  // (*) 마술은 일어나지 않습니다.
  alert( `Hello, ${name}` );
};

