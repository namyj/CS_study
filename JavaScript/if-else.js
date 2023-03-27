// if 문
let year = prompt("Insert 2015",''); // string
if (year == 2015) alert("Correct!"); // string과 숫자 비교 -> 숫자로 형변환

if (year < 2015) {
    alert("if block");
} else if (year > 2016) {
    alert("else if block")
} else {
    alert("else block");
}

// 0, "", null, undefined, NaN -> false
if (0) {
    alert("if block 1");
}

if (1) {
    alert("if block 2");
}

/*
조건부 연산자 ?
let result = confition ? value1 : value2;
- condition이 true -> value1 / false -> value2
*/
let insert_value = prompt("Insert number",'')
let result = (insert_value > 10) ? "over 10": "lower 10"; // result = insert_value > 10 ? true: false; 동일  
alert(result)

// 다중 ?
let age = prompt("Insert age", '')
let result = (age < 3) ? "lower than 3": 
    (age < 18) ? "greater than 3 and lower than 18" : 
    (age < 100) ? "greater than 18 and lower than 100" : 
    "else";

alert(result)

if (age < 3) {
    result = 1;
} else if (age < 18) {
    result = 2;
} else if (age < 100) {
    result = 3;
} else {
    result = 4;
}

// HW1
if ("0") { // 빈 문자열 제외한 문자열 -> true
    alert("if block"); // 실행
}

// HW2
let value = prompt("Insert JS name",'');
if (value == "ECMAScript") {
    alert("Correct");
} else {
    alert("Wrong");
}

// HW3
let value = prompt("Insert Num",0);
if (value == 0) {
    alert(0)
} else if (value > 0) {
    alert(1)
} else {
    alert(-1)
}

// HW4
let result = ( a+b < 4 ) ? "미만" : "이상";

// HW5
let result = (login=="1") ? "first":
    (login=="2") ? "second" : 
    (login=="") ? "third" : 
    "";
