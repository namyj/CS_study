// (dynamically typed language)
// varibale can be allocated any type of value
let msg = 123;
msg = "msg";

// Number
// integer , floating point number , special numeric value (Infinity , -Infinity , NaN) 
let n = 123;
n = 12.34;

alert(1/0); // Infinity
alert(Infinity);

alert("not Number" / 2); // NaN <- 부정확 or 정의되지 않은 연산의 경우에 에러 발생 
// 연산 과정에서 NaN 이 발생하면, 모든 결과에 영향을 미침 -> 최종 결과는 무조건 NaN

// BigInt : 길이 제한없는 정수
const BIGINT = 123123123123123123123n; 

// String
let str1 = "string 1";
let str2 = 'string 2';
let num = 3;
let str3 = `string ${num}` // backtick : can insert a variable or expression's value
alert(str3)

// Boolean
let bool1 = true;
let bool2 = false;

let result = 4 > 1; // true
alert(result);

// Null - 존재하지 않는 값, 비어있는 값, 알수 없는 값 (nothing, empty, unknown)
let age = null; 

// Undefined - 값이 할당 되지 않음
let age2;
alert(age2);
let age3 = undefined;

typeof age;
typeof(age);