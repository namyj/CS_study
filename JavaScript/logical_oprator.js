// OR (||)
// 피연산자가 불린형이 아닌 경우, 불린형으로 변환후 연산
alert(true || false); // true
alert(0 || false); // false

if (1||0) { // 1 -> true, 0 -> false
    alert("true");
}

let hour = 12;
let is_weekend = true;

if (hour < 10 || hour > 18 || is_weekend ){
    alert("if block");
}

/*
result = value1 || value2 || value3
- "처음 만나는 true 반환"
- 피연산자 형 변환 -> true를 만나면 연산을 멈추고 해당 피연산자 반환, true 가 없는 경우 마지막 피연산자를 반환
*/
alert( 1 || 0); // 1
alert(null || 1); // 1
alert(null || 0 || 1); // 1
alert(undefined || null || 0); // 0, 모든 피연산자가 형변환 시 false로 마지막 피연산자 반환

// Case1: 값이 존재하는 변수의 값만 출력
alert( var1 || var2 || var3 || "None"); 
// Case2: 단락 평가, 연산자 왼쪽 조건이 false 일때만 명령어를 실행하고자 할때
alert(true || "true");
alert(false || "false"); // 이 메시지만 출력

// AND (&&)
if (1 && 0){ // 1 -> true, 0 -> false 
    alert("if block")
}

/*
result = value1 && value2 && value3
- "처음 만나는 false 반환"
- 피연산자 형 변환 -> false를 만나면 연산을 멈추고 해당 피연산자 반환, false가 없는 경우 마지막 피연산자 반환
*/
// 첫번째 피연산자가 true, 두번째 피연산자 반환
alert(1 && 0); // 0
alert(1 && 5); // 5 (false 가 없음)
alert(null && 5); // null
alert(0 && "anything"); // 0
alert(true && false); // false
alert(true && true); // true
alert(true && 0); // 0
alert(0 && false); // 0
alert(false && 0); // false

// 주의: 연산 우선수위 && > ||

// NOT (!)
// 피연산자 형 변환 -> 역 값 반환
alert(!true);
alert(!0);

// !! : Boolean() 동일 역할
alert(!!"hello"); // true
alert(!!null); // false
alert(!!undefined); // false

// HW1
alert(null || 2 || undefined); // 2 출력

// HW2
alert( alert(1) || 2 || alert(3)); // 1 -> 2 출력, alert는 값을 반환하지 않음 = undefined

// HW3
alert(1 && null && 2); // null 출력

// HW4
alert(alert(1) && alert(2)); // 1 -> undefined 출력

// HW5
alert(null || 2 && 3 || 4); // 3

// HW6
let age;
if (age >= 14 && age <= 90) {
    alert("if block");
}

// HW7
if (age < 14 || age > 90) {
    alert("if block");
}

if (!(age >= 14 && age <= 90)){
    alert("if block");
}

// HW8
if (-1 || 0) alert( 'first' ); // 출력
if (-1 && 0) alert( 'second' ); // X
if (null || -1 && 1) alert( 'third' ); // 출력

// HW9
let id = prompt("Login ID", "");

if (id == "Admin") {
    let pwd = prompt("Login Password", "");
    if (pwd == "TheMaster") {
        alert("Welcome");
    } else if (pwd) {
        alert("Authorizing failed");
    } else {
        alert("Canceled");
    }
} else if (id) {
    alert("Unknown User");
} else { // else if (id == '' || id == null)
    alert("Canceled");
}