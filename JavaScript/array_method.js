let arr = ['1', '2', '3'];
delete arr[1];
alert(arr[1]); // undefined
alert(arr); // 1,,3
alert(arr.length); // 3, 원소를 삭제해도 해당 공간을 유지함. 




/*
arr.splice(index[, deleteCount, elem1, ... elemN]);
- index: 해당하는 원소 시작 위치
- deleteCount: 제거할 원소 개수
- elem1, ... elemN: 배열에 추가할 원소들
*/
let arr = ['1', '2', '3'];
arr.splice(1, 1) // 인덱스 1 부터 1개 원소 삭제후, 나머지 원소를 앞으로 당김
alert(arr); // 1,3

let arr2 = ['1', '2', '3'];
let result = arr2.splice(0, 2, 'sp 1', 'sp 2'); // 0 부터 요소 두개를 삭제하고, 그 자리에 원소 두개 삽입
alert(arr2);
alert(result);

// deleteCount = 0 으로 설정하면, 원소 삭제 없이 해당 위치에 원소 삽입 가능
let arr = ['1', '2', '3'];
arr.splice(1, 0, 'sp 1', 'sp 2'); 
alert(arr);

/*
arr.slice([start], [end])
- 인덱스 start 부터 end-1 까지 원소를 복사한 새로운 배열 반환 
- end 생략 = 배열 끝까지
- 주의) end 를 포함하지 않음
*/
let arr = ["t", "e", "s", "t"];
alert( arr.slice(1, 3) ) // "e", "s"

/*
arr.concat(arg1, arg2...)
- 배열 연결하기
- arr애 속한 모든 원소와 arg1, arg2... 에 들어있는 모든 원소를 모아서 새로운 배열 반환
*/
let arr = [1, 2];
alert( arr.concat([3, 4]) ); // 1,2,3,4
alert(arr.concat([3, 4], [5, 6]) ); // 1,2,3,4,5,6
alert( arr.concat([3, 4], 5, 6) ); // 1,2,3,4,5,6

// arg에 객체가 들어오면, 객체는 분해하지 않고 통으로 붙여넣음
let arrayLike = {
    0: "something",
    length: 1
};
alert( arr.concat(arrayLike) ); // 1,2,[object Object]

// 하지만, 유사배열 객체(키가 숫자, length 프로퍼티 존재)에 Symbol.isConcatSpreadable 프로퍼티가 있으면 분해해서 붙여넣음
let arrayLike2 = {
    0: "something",
    1: "else",
    [Symbol.isConcatSpreadable]: true,
    length: 2
};
alert( arr.concat(arrayLike2) ); // 1,2,something,else

/*
arr.forEach( function(item, index, array) {
  // 배열의 각 요소에 함수 적용
  // 반환값을 넘겨도 무시되
});
*/
let arr = ["Bilbo", "Gandalf", "Nazgul"]
arr.forEach((item, index, array) => {
    alert(`${item} is at index ${index} in ${array}`);
});


// 원소 찾기 (===)
let arr = [1, 0, false];

// arr.indexOf(item, from)
// 배열의 인덱스 from 부터 원소를 찾음, 찾으면 해당 인덱스 반환, 없으면 -1 반환
// arr.lastIndexOf(item, from) : 탐색을 끝부터 시작
alert( arr.indexOf(0) ); // 1
alert( arr.indexOf(false) ); // 2
alert( arr.indexOf(null) ); // -1, 해당 원소 존재 안함

// arr.includes(item)
// 배열에 원소가 존재 -> true, 없음 -> false
alert( arr.includes(1) ); // true

const arr = [NaN];
alert(arr.indexOf(NaN)); // -1, === 비교로 NaN을 찾을 수 없음
alert(arr.includes(NaN)); // true, NaN 여부 확인 가능

// 객체로 이뤄진 배열에서 객체 찾기
/*
let result = arr.find(function(item, index, array) {
  // true가 반환되면 반복이 멈추고 해당 요소를 반환합니다.
  // 조건에 해당하는 요소가 없으면 undefined를 반환합니다.
});
- item : 함수를 호출할 요소
- index : 요소의 인덱스
- array : 배열 
*/

let users = [
    {id: 1, name: "John"},
    {id: 2, name: "Pete"},
    {id: 3, name: "Mary"}
];
  
let user = users.find(item => item.id == 1);

/*
let result = arr.map(function(item, index, array) {
  // 요소 대신 새로운 값을 반환합니다.
});
*/
let lengths = ["Bilbo", "Gandalf", "Nazgul"].map(item => item.length);
alert(lengths); // 5,7,6

// // 배열 정렬
// // (default) 원소를 문자열 취급해서 정렬
// let arr = [ 1, 2, 15 ];
// arr.sort();

// alert( arr );  // 1, 15, 2

// 원하는 방식의 정렬 함수 전달 가능
// 조건) 값 두개 비교, 반환값 존재
function compareNumeric(a, b) {
    if (a > b) return 1; 
    if (a == b) return 0;
    if (a < b) return -1;
}
  
let arr = [ 1, 2, 15 ];
arr.sort(compareNumeric);
alert(arr);  // 1, 2, 15

// 동일 결과
arr.sort(function(a, b) { return a - b; });
arr.sort( (a, b) => a - b );

// 문자열 정렬
let countries = ['Österreich', 'Andorra', 'Vietnam'];

alert( countries.sort( (a, b) => a > b ? 1 : -1) ); // Andorra, Vietnam, Österreich (제대로 정렬이 되지 않았습니다.)
alert( countries.sort( (a, b) => a.localeCompare(b) ) );

