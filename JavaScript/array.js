// 배열
// 순서가 있는 데이터를 저장하는 자료구조 (특별한 종류의 객체)

// 배열 선언
let arr = new Array();
let arr2 = [];

// 초기화
// 배열의 마지막 요소도 , 로 끝날 수 있음
let fruits = ['apple', 'grape', 'orange', ]; // 인덱스 0, 1, 2
alert(fruits);

// 원소 접근
alert(fruits[0]);
alert(fruits[1]);
alert(fruits[2]);

fruits[2] = 'pears';
alert(fruits[2]);

// 원소 추가
fruits[3] = 'lemon';

// length 프로퍼티
alert(fruits.length); 

// 배열 원소 자료형엔 제약이 없음 (함수, 문자열, 숫자, 객체... 전부 가능)
let arr3 = [ '사과', { name: '이보라' }, true, function() { alert('hello.'); } ];
arr3[3]();

/* 
[배열로 구현 가능한 자료구조]
Queue (FIFO)
- push: 맨 끝에 원소 추가
- shift: 맨 앞의 원소 꺼낸 후, 남은 요소 앞으로 밀기 

Stack (LIFO)
- push: 스택 맨 끝에 원소 추가
- pop: 스택 끝 요소 추출
*/

let arr = ['a', 'b', 'c'];
alert(arr.pop()); // c를 꺼내고, [a,b] 만 남음
alert(arr);


arr.push('d'); // === arr[arr.length] = 'd'
alert(arr);

let arr = ['a', 'b', 'c'];
alert(arr.shift()); // a를 꺼내고, [b,c] 만 남음
alert(arr);

arr.unshift('x');
alert(arr);

// push, unshift - 여러개 요소를 한번에 넣기 가능
arr.push('push 1', 'push 2');
arr.unshift('unshift 1', 'unshift 2');
alert(arr);

// 배열 = 특별한 종류 객체, 키가 '숫자'
let fruits = ['apple'];
let copy_fruits = fruits; // 주소가 복사됨
alert(copy_fruits === fruits); // true

// 참조를 통해 배열을 수정하면 원본이 수정됨
copy_fruits.push('banana');
alert(fruits);
// 그렇다고 일반 객체처럼 사용하면, 배열의 이점이 사라지기 때문에 권장 X


let arr = ['apple', 'banana', 'orange'];

// 인덱스 접근
alert('index');
for (let i=0; i<arr.length; i++){
    alert(arr[i]);
}

// 값 접근 (인덱스 X)
alert('value');
for (let fruit of arr) {
    alert(fruit);
} 

// key 접근 (객체형)
// but, 권장하지 않음 (모든 프로퍼티를 대상으로 순회하기 때문에 유사 배열 객체의 경우 이상하게 동작할 가능성 존재 / 느리다)
alert('key of object');
for (let key in arr) {
    alert(arr[key]);
}

// length 프로퍼티
// 가장 큰 인덱스 + 1
let fruits = [];
fruits[123] = "사과";
alert( fruits.length ); // 123 + 1 = 124

// length를 수동으로 증감 가능
// 증가는 상관없지만, 감소시킬 경우 배열이 잘리고 복구 불가능

// new Arrary()
// 권장하지 않음
let arr = new Array(2); // 인덱스가 2개인 배열 생성됨, 값이 로 들어가진 않음

// 다차원 배열
let matrix = [
    [0,0],
    [1,1],
    [2,2]    
];
alert(matrix);

// 배열에 toString 메소드가 구현되어서, 문자열 변환이 자연스럽게 이루어짐
// Symbol.toPrimitive, valueOf 메서드 X
alert( [] + 1 ); // "1"
alert( [1] + 1 ); // "11"
alert( [1,2] + 1 ); // "1,21"

// HW2
let styles = ['jazz', 'blues'];
alert(styles);
styles.push('R-n-R');
alert(styles);
styles[Math.trunc(styles.length/2)] = 'Classic';
// styles[Math.floor((styles.length - 1) / 2)] = "Classics";
alert(styles);
alert(styles.shift());
alert(styles);
styles.unshift('Rap', 'Raggage');
alert(styles);

// HW4
function sumInput() {
    let arr = [];
    while (true) {
        let num = prompt("input number?", 0);
        if (num === '' || num === null || !isFinite(num)) break;
        arr.push(+num);
    }
  
    let sum = 0;
    for (let i of arr) {
        sum += i;
    }
    return sum;
};

alert(sumInput());