// while
// 최소 0 번 이상 실행
let i = 1;
while (i<3){
    i++;
}

let i = 2;
while (i) i--; // i=0 -> false -> 반복 종료

// do-while
// 최소 1 번 이상 실행
do {
    // command
} while (condition) 

// for
for (let i=0; i<3 ; i++){
    // command
}
alert(i) // error

// 구성요소 생략, 세미콜론은 필수!
let i = 0;
for (;i<3;){
    // command
    i++;
}

let sum = 0;
while (true) {
    let value = +prompt("Insert Number",""); // + 로 숫자형 변환

    if (!value) break; // 값을 입력하지 않으면 반복 종료

    sum += value;
}

// 주의) ? 오른편에 continue or break 이 올수 없음
(i > 5) ? alert(i) : continue; // error

/*
레이블
- 반복문 앞에 붙이는 식별자
- 레이블을 별도 줄에 붙이는 것도 가능
- break label / continue label -> label 해당하는 반복문을 종료 또는 다음 스텝으로 넘어감
*/
outer: for (let i = 0; i < 3; i++) {

    for (let j = 0; j < 3; j++) {
      let input = prompt(`(${i},${j})의 값`, '');
      if (!input) break outer; // 바깥 for 문 종료
    }
}
alert('완료!');

// 주의) break, continue 는 반복문 안에서만 사용 가능
// 주의) 레이블은 반드시 break, continue 이전에 정의 되어야함

// HW1
let i = 3;

while (i) {
  alert( i-- ); // 3 -> 2 -> 1
}

// HW2
let i = 0;
while (++i < 5) alert( i ); // 1 2 3 4 

let i = 0;
while (i++ < 5) alert( i ); // 1 2 3 4 5

// HW3
for (let i = 0; i < 5; i++) alert( i ); // 0 1 2 3 4 

for (let i = 0; i < 5; ++i) alert( i ); // 0 1 2 3 4

// HW4
for (let i = 2; i<=10 ; i += 2) alert(i);

// HW5
let i = 0;
while(i<3){
    alert(`number ${i++}`);
}

// HW6
while (true) {
    let insert = +prompt("Insert Number greater than 100","");
    if ((insert > 100) || !insert)  break;
}

do {
    let insert = prompt("Insert Number greater than 100",0);
} while (insert <=100 && insert);

// HW7
let num = prompt("Insert Number",0);
outer:
for(let i = 2; i<=num ; i++){
    for (let j=2; j < i ; j++){
        if (i%j == 0) continue outer; // 소수가 아니므로 다음 i로 넘어감
    }
    alert(i); // 나눌 수 있는 수를 찾지 못했을 때만 여기가 실행 됨
}