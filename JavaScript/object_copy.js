// 객체 참조값 복사
// 변수에 객체의 참조값이 저장됨 (실제 저장된 메모리는 다름)
let user = { name: "John" };
let admin = user; 

// admin, user 모두 객체에 접근 가능
alert(admin.name);
alert(user.name);
alert(admin === user ); // true

// 객체 복제
// 방법1) 직접 property를 복사
/*
방법2) Object.assign
Object.assign(dest, [src1, src2, ...]);
- dest: 목표로 하는 객체
- src: 복사할 객체
- dest를 반환
*/

let user = { name: "John" };
let permissions1 = { canView: true };
let permissions2 = { canEdit: true };

// permissions1과 permissions2의 프로퍼티를 user로 복사합니다.
Object.assign(user, permissions1, permissions2);
for (let key in user) {
    alert(`${key}, ${user[key]}`)
}

// 만약, user에 동일한 이름을 가지는 property가 있는 경우 기존값이 덮어씌워짐 
let user = { name: "John" };
Object.assign(user, { name: "Pete" });

alert(user.name); // Pete

let user = {
    name: "John",
    age: 30
};
  
let clone = Object.assign({}, user);

// 중첩 객체 복제
// user[key]의 각 값을 검사하면서, 그 값이 객체인 경우 객체의 구조도 복사해주는 반복문을 사용
let user = {
    name: "John",
    sizes: { // 이 값을 복제하고 싶은 경우
      height: 182,
      width: 50
    }
};
  