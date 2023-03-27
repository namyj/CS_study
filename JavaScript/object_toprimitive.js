// 객체의 형 변환
// 객체의 논리 평가시 변환 : 항상 true 

// obj -> string
var obj = {};
alert(obj); // case1) 객체 출력
anotherobj[obj] = 123; // case2) 객체를 다른 객체의 키로 사용

// obj -> number
let num = Number(obj); // case1) 명시적 형변환
let n = +obj; // case2) 수학 연산
let delete = date_obj1 - date_obj2;
let result = user_obj1 > user_obj1; // case3) 대소 비교 (피연산자에 문자열, number 둘다 가능하지만 객체는 number 변환으로 고정)

// obj -> default (사용하는 연산자가 기대하는 자료형이 명확하지 않을때, 매우 드물다)
let title = obj1 + obj2; // case1) 이항 덧셈 연산
let result = obj == 1; // case2) obj == Number

/*
자바 스크립트 형변환
1. 객체에 obj[Symbol.toPrimitive](hint) 확인 
    -> 메서드 존재 & 호출 (Symbol.toPrimitive : 시스템 심볼, 심볼형 키로 사용)
2. 1에 해당하지 않고 hint가 "string"
    -> obj.toString() -> obj.valueOf() 호출 (존재하는 메서드만 실행됨).
3. 1과 2에 해당하지 않고, hint가 "number"나 "default"
    -> obj.valueOf() -> obj.toString() 호출 (존재하는 메서드만 실행됨).
*/

// 목표로 하는 자료형 명명
obj[Symbol.toPrimitive] = function(hint) {
    // 반드시 원시값을 반환해야 합니다.
    // hint : "string", "number", "default" 중 하나
};

let user = {
    name: "John",
    money: 1000,
  
    // 객체 내장 심볼
    [Symbol.toPrimitive](hint) {
      alert(`hint: ${hint}`);
      return hint == "string" ? `{name: "${this.name}"}` : this.money;
    }
};

alert(user); // hint: string -> {name: "John"}
alert(+user); // hint: number -> 1000
alert(user + 500); // hint: default -> 1500


/**
toString
- (일반적) [object Object] 반환
valueof
- (일반적) 객체 자신을 반환
 */
let user = {name: "John"};

alert(user); // [object Object]
alert(user.valueOf() === user); // true
alert(user === user);

// 모든 형변환을 한곳에서 처리해야 하는 경우 -> toString 만 구현
// 일반적으로 valueof 는 객체 자신을 반환하기 때문에, 무시된다. 그래서 toString 만 구현해주면 됨
let user = {
    name: "John",
  
    toString() {
      return this.name;
    }
};    
  
alert(user); // toString -> John
alert(user + 500); // toString -> John500
