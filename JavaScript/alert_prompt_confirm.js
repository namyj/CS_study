/* 
alert(message)
메시지창
- message : show message
*/
alert("alert message");

/*
result = prompt(title, default)
입력창
- title : show message
- default : (optional) initial value
- 메시지 입력 -> string, '취소, Esc' -> null
*/
let age = prompt("Insert Age", 0);
alert(`Your age is ${age}`);

let test1 = prompt("Test");
let test2 = prompt("Test", '');

/* 
result = confirm(question)
확인, 취소 버튼창 
- question : show message
- If user click "확인" -> true, "취소" -> false 
*/
let check = confirm("Question?");
alert(check);

// HW
let age2 = prompt("Insert Your age");
alert(`Your age is ${age2}`);