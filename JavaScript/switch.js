// switch <- 복수의 if 문
// 표현식의 형식에 제한이 없음
switch(x) {
    case "value1":
        // command
    case "value2":
        // command
    default:
        // command
}

let a = 2 + 2;
let b = 1;
switch (a) {
  case b+1: // 3
    alert( '비교하려는 값보다 작습니다.' );
    break;
  case 4: // 이 case 문 실행
    alert( '비교하려는 값과 일치합니다.' );
    break; // break 가 존재하지 않으면, 해당 case 문 아래 모든 코드 실행
  case 5:
    alert( '비교하려는 값보다 큽니다.' );
    break;
  default:
    alert( "어떤 값인지 파악이 되지 않습니다." );
}

// 실행할 코드가 동일하면, 묶을 수 있음
let a = 3;
switch (a) {
  case 4:
    alert('계산이 맞습니다!');
    break;
  case 3: // 두 case문을 묶음
  case 5:
    alert('계산이 틀립니다!');
    break;
  default:
    alert('계산 결과가 이상하네요.');
}

// 주의) 자료형이 동일해야 해당 case 문 실행
let arg = prompt("값을 입력해주세요.");
switch (arg) {
  case '0':
  case '1':
    alert( '0이나 1을 입력하셨습니다.' );
    break;

  case '2':
    alert( '2를 입력하셨습니다.' );
    break;

  case 3: // Number, agr 는 문자열이기 때문에 절대 실행되지 않음 
    alert( '이 코드는 절대 실행되지 않습니다!' );
    break;
  default:
    alert( '알 수 없는 값을 입력하셨습니다.' );
}

// HW1
let browser;
if (browser == "Edge") alert("1");
else if ((browser == "Chrome") || (browser == "Firefox") || (browser == "Safari") || (browser == "Opera")) alert("2");
else alert("3")

// HW2
let a = +prompt('a?', '');

switch(a) {
    case 0:
        alert(0);
        break;
    case 1:
        alert(1);
        break;
    case 2:
    case 3:
        alert('2,3');
        break;
}