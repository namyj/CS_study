// 객체형

let obj1 = new Object(); // 객체 생성자
let obj2 = {}; // 객체 리터럴

// key:value 
let user = {
    name: "Kim",
    age: 30,
    "like bird":true,
}

// value 접근
alert(user.name);
alert(user.age);
alert(user["like bird"])
// property 추가
user.isAdmin = true;

// property 삭제
delete user.age;

// 주의) const 로 선언된 객체도 수정이 가능
// const는 user를 전체적으로 설정할때만 오류
const obj3 = {
    name:"Nam"
};
obj3.name = "Kim"; // 정상 동작
obj3.key = "value"; // 정상 동작
alert(obj3.key);


// 변수도 property 키로 사용 가능
// -> 사용자 입력에 따라 유연하게 작성 가능 
let obj = {};
let key = "key 1"
obj[key] = true; 

let user = {
    name:"Kim",
    age:30
}

let key = prompt("Insert key", "name");
alert(user[key]);
// 주의) 점 표기법은 불가능
alert(user.key) // error 

// computed property
let fruit = prompt("Insert fruit", "apple");
let bag = {
    [fruit]:5, // 변수 fruit에서 property 이름을 동적으로 받아옴 
};
alert(bag.apple);

// 동일한 동작
let fruit = prompt("Insert fruit", "apple");
let bag = {};
bag[fruit] = 5;

// property value shorthand
// key와 변수 이름이 동일한 경우, 단축 구문을 사용해 설정 가능
function makeUser(name, age) {
    return {
      name: name,
      age: age,
      // ...등등
    };
}
// 위와 동일
function makeUser(name, age) {
    return {
      name, // == name:name 
      age,  // == age:age 
      // ...
    };
}

let user = makeUser("John", 30);
alert(user.name); // John

// 객체에서도 사용 가능
let name = "Kim";
let user = {
    name, // == name:name
    age: 30
}

// property 이름에는 특별한 제약이 없음
// 문자형, 심볼형에 속하지 않으면, 문자형으로 자동 변환
let obj = {
    0:"test" // 0 -> "0"
};
alert(obj["0"]) // obj[0]

// property 존재 여부 확인
// 존재하지 않는 property에 접근하는 경우 -> undefined 반환
let obj = {
    "key":"value",
};
alert(obj.property === undefined); // true

alert("key" in obj); // true
alert("name" in obj); // false

// 객체 내 모든 키를 접근 가능
let user = {
    name: "John",
    age: 30,
    isAdmin: true
};

for (key in user) {
    alert(key);
    alert(user[key]);
}

// property 순서
// 정수 property: 자동 정렬, 그외 property: 객체에 추가한 순서로 정렬
let codes = {
    "49": "독일",
    "41": "스위스",
    "44": "영국",
    // ..,
    "1": "미국"
};

for (let code in codes) {
    alert(code); // 숫자 크기로 정렬
}

let user = {
    name:"KIM",
    subname:"NAM"
};
user.age = 25;

for (let key in user){
    alert(key); // property 추가 순서로 정렬
}

// HW!
let user = {};
user.name = "John";
user.subname = "Smith";
user.name = "Pete";
delete user.name;

// HW2
function isEmpty(obj){
    for (let key in obj){
        return false
    }
    return true
}
let schedule = {};
alert( isEmpty(schedule) ); // true

schedule["8:30"] = "get up";

alert( isEmpty(schedule) ); // false

// HW3
let salaries = {
    John: 100,
    Ann: 160,
    Pete: 130
};

function sumSalary(salary) {
    let result = 0;
    for (let key in salary) {
        result += salary[key];
    }
    return result
}   
let sum = sumSalary(salaries);
alert(sum);

// HW4
let menu = {
    width: 200,
    height: 300,
    title: "My menu"
};

function multiple(obj) {
    for (let key in obj){
        if (typeof obj[key] == "number") 
            obj[key] *= 2;
    }
    return obj;
}

multiple(menu);
alert(menu.width);
alert(menu.height);
alert(menu.title);