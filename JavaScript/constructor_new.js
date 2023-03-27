/*
생성자 함수 (constructor function)
- 함수명의 첫 글자가 대문자로 시작
- 반드시 new 연산자를 붙여 실행
- (new 연산자를 붙여 실행하면) 모든 함수는 생성자 함수가 될수 있음 
*/

function User(name){
    this.name = name;
    this.isAdmin = false;
}
let user = new User("Kim");
alert(user.name);
alert(user.isAdmin);

/*
1. 빈 객체를 만들어 this에 할당
2. 함수 본문을 실행 (위에 할당한 this 사용)
3. this 반환
*/

// 익명 생성자 함수 (for 코드 캡슐화)
let user1 = new function() {
    this.name = "John";
    this.isAdmin = false;
  
    // 사용자 객체를 만들기 위한 여러 코드.
    // 지역 변수, 복잡한 로직, 구문 등의
    // 다양한 코드가 여기에 들어갑니다.
};


/*
new.target
- 함수가 new와 함께 호출되었는지 확인
- 그냥 함수 호출 -> new.target = undefined
- new와 함께 호출 -> new.target = 함수 자체
*/

function User() {
    // new를 붙이지 않아도, new를 붙여줌
    if (!new.target) { 
        return new User(name); 
    }

    alert(new.target);
}
  
// 'new' 없이 호출함
User(); // undefined

// 'new'를 붙여 호출함
new User(); // function User { ... }

/*
생성자 return 
- return 객체 -> this 대신 객체 리턴
- return 원시형 -> this 리턴  
*/

function User3() {
    this.name = "test";
    return { name: "return test"};
    // return; // this 반환됨
}

alert(new User3().name); // return test 가 반환됨

function User4(name) {
    this.name = name;
    this.func_test = function() { // 객체 메소드
        alert(`hello, ${name}`);
    }
}

let obj = new User4("Nam")
obj.func_test()

// HW1
const obj = {};
function A(var1) {
    return var1;
}
function B(var1) {
    return var1;
}

let a = new A(obj);
let b = new B(obj);
alert(a == b);	

/*
// solution
let obj = {}; // 전역에 객체 생성

function A() { return obj; }
function B() { return obj; }

alert( new A() == new B() );
*/

// HW2
function Calculator() {
    this.read = function() {
        this.op1 = +prompt("Insert number",0);
        this.op2 = +prompt("Insert number",0);
    }, 
    this.sum = function() {
        return this.op1 + this.op2;
    },
    this.mul = function() {
        return this.op1 * this.op2;
    }
}

let calc = new Calculator();
calc.read()
alert("Sum= "+calc.sum());
alert("Mul= "+calc.mul());

function Accumulator(starting_value) {
    this.value = starting_value;
    this.read = function() {
        this.value += +prompt("Insert Number",0);
    }
}

let acc = new Accumulator(1);
acc.read();
acc.read();

alert(acc.value);