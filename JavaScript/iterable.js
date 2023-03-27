// iterable 객체
// 일반 객체를 for-of 가 가능하게 하려면, Symbol.iterator 메서드 추가
let range = {
    from: 1,
    to: 5,
};

/*
[Symbol.iterator] {
- 반드시 이터레이터 객체 반환
- next() 메서드 구현
- next() 반환값 : {done: Boolean, value: any} / done 반복 종료 여부
}
*/

range[Symbol.iterator] = function(){
    return {
        current : this.from,
        last : this.to,
        next() {
            if(this.current <= this.last) {
                return {done: false, value: this.current++};
            } else {
                return {done:true};
            }
        }
    };
};

let range = {
    from: 1,
    to: 5,
  
    [Symbol.iterator]() {
      this.current = this.from;
      return this;
    },
  
    next() {
      if (this.current <= this.to) {
        return { done: false, value: this.current++ };
      } else {
        return { done: true };
      }
    }
};

for (let num of range) {
    alert(num); // 1, then 2, 3, 4, 5
}

// 이터레이터 명시적 호출
let str = "helo";
let iter = str[Symbol.iterator]();
while (true) {
    let result = iterator.next();
    if (result.done) break;
    alert(result.value); // 글자가 하나씩 출력됩니다.
}

// 유사 배열
// 인덱스, length 프로퍼티 존재
// 하지만 이터레이터 객체는 아님
let arrayLike = { 
    0: "Hello",
    1: "World",
    length: 2
};

// Array.from()
// 유사배열을 진짜 배열로 만들어줌
let arr = Array.from(arrayLike);

// 매핑 함수 전달
// Array.from(obj[, mapFn, thisArg])
// obj의 각 요소를 대상으로 매핑 함수 mapFn 을 적용후 새로운 배열 반환
// thisArg: 각 요소의 this를 지정 가능 

let arr = Array.from(range, num => num * num); // 각 요소를 제곱한 새로운 배열 생성
 