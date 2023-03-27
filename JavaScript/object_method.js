// // method
// let user = {
//     name:"Kim",
//     age:20
// };

// // method 할당
// user.sayHi = function () {
//     alert("hi");
// }

// // 선언된 함수를 method 등록
// // function sayHi() {
// //     alert("hi");
// // }
// // user.sayHi = sayHi;

// user.sayHi();

// // 단축 구문
// user = {
//     sayHi: function() {
//         alert("hi");
//     }
// };

// // 위와 동일
// user = {
//     sayHi() { // function 생략해도 메서드 정의 가능
//         alert("hi");
//     }
// };

// // this
// // 객체의 property 접근을 가능하게 함
// let user = {
//     name:"Kim",
//     age:30,
//     sayHi() {
//         alert(`${this.name} Hi`);
//         // alert(`${user.name} Hi`); // 외부 변수 참조 가능, but 에러가 발생할 가능성 높음
//     }
// };

// user.sayHi();

// // 모든 함수에 this 사용 가능
// // 함수가 호출되기 전에 this에 값이 할당되지 않음
// function sayHi() {
//     alert(this.name); // this 값은 런타임에 결정됨
// }

// let user1 = {name:"KIM"};
// let user2 = {name:"NAM"};

// user1.f = sayHi;
// user2.f = sayHi;

// // 함수를 호출하는 객체에 따라 값이 달라짐
// user1.f();
// user2.f();
// user2['f'](); // 점 == 대괄호

// // 객체 없이 호출
// // strict 모드가 아닌 경우, 호출하는 객체가 없다면 this는 전역 객체를 참조
// function func() {
//     alert(this); 
// }
// func(); // undefined

// // 화살표 함수 : 고유한 this 가지지 않음
// // 화살표 함수에서 this를 참조 -> 외부 함수에서 this 값을 참조
// let user = {
//     name:"a",
//     sayHi() {
//         let arr = () => alert(this.name); // 화살표 함수 내 this.name -> 바깥 name 참조됨
//         arr(); 
//     }
// };
// user.sayHi();

// HW1
// this 값은 호출 시점에 결정됨
function makeUser() {
    return {
      name: "John",
      ref: this
    };
};

let user = makeUser(); // 호출 시점에 this = 함수 = undefined
alert( user.ref.name ); // Error

// HW2
let calc = {
    read : function() {
        this.op1 = prompt("operand1", 0); 
        this.op2 = prompt("operand2", 0);
    },
    sum() {
        return this.op1 + this.op2
    },
    mul() {
        return this.op1 * this.op2
    }
};

// HW3
let ladder = {
    step: 0,
    up() {
      this.step++;
      return this
    },
    down() {
      this.step--;
      return this
    },
    showStep: function() { // 사다리에서 몇 번째 단에 올라와 있는지 보여줌
      alert( this.step );
    }
};

ladder.up().up().down().showStep();