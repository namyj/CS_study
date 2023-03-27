// optional chaining

// 객체에 존재하지 않는 프로퍼티에 접근하는 경우 에러 발생
let user = {};
alert(user.name); // error

// && 처리
// 프로퍼티가 없는 경우, undefined 반환
alert(user && user.address && user.address.street); // undefined

/*
[객체]?.[property]
- ?. 앞 변수의 값이 존재하는지 확인, 존재하지 않는 경우 undefined 반환
- ?. 앞 변수는 반드시 선언되어 있어야함
- ?.의 평가가 멈추면 남은 뒷부분은 평가되지 않음
*/
let user = {};
alert(user?.address); // undefined
alert(user?.address.street); // undefined

// ?.()
// 함수의 존재 여부 확인
let user1 = {
    admin() {
        alert("Is admin");
    }
}

let user2 = {};
user1.admin?.(); // 함수 정상 수행
user2.admin?.(); // error 발생 안함

// ?.[]
// 프로퍼티 존재 여부 확인
let user3 = {
    firstName: "Violet"
};
  
let user4 = null;  
let key = "firstName";

alert(user3?.[key]);
alert(user4?.[key]); // undefined

// ?. 사용한 삭제
// 삭제할 프로퍼티의 존재 여부를 확인하고 삭제, 해당 프로퍼티가 없더라도 에러 발생 안함
delete user?.name; 

// 주의) ?. 는 읽기, 삭제에만 사용 가능 / 쓰기에는 사용할 수 없음
