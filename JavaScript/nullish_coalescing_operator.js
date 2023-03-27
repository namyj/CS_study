/*
nullsish 병합 연산자 (nullsish coalescing operator)
result = a ?? b
- a 가 null, undefined 가 아닌 경우 -> a
- 그 외 경우 -> b
*/
result = a ?? b
result = (a !== null && a !== undefined) ? a : b;

let var1 = "";
let var2 = "";
let var3 = "violet";

// null or undefined 가 아닌 값 출력
alert(var1 ?? var2 ?? var3 ?? "unknown user")

/*
OR vs ??
- OR : 첫번째 true 반환
- ?? : 첫번째 정의된 값 반환, null, undefined 와 0을 구분할 수 있음 
*/
let height = 0; // 정의된 값
alert(height || 100); // 100
alert(height ?? 100); // 0

// 주의) 연산자 우선순위가 낮기 때문에, 괄호 사용 권장
// 주의) ??는 ||, && 와 함께 사용 불가능
let x = 1 && 2 ?? 3; // 에러
let x = (1 && 2) ?? 3; // 정상 동작 