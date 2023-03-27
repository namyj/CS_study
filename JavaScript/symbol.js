// Symbol
// 유일한 식별자
// Symbol('description');

// description이 동일한 심볼을 생성해도, 각 심볼값은 서로 다름
let id1 = Symbol('id');
let id2 = Symbol('id');
alert(id1 == id2); // false

// description 출력
alert(id1.description);

// 주의) 심볼은 문자형으로 자동 형변환되지 않음
alert(id1) // error, alert는 문자형 인자를 요구하기 때문
// 해결
alert(id1.toString())

// hidden property 생성
// 외부 코드에서 접근 불가능하고 값을 덮어쓸수 없는 프로퍼티
let user = { // 외부 코드에서 가져온 객체
    name: "John"
};
  
let id = Symbol("id");
user[id] = 1; // 외부 코드에서 접근 불가능한 프로퍼티 추가

alert( user[id] ); // 심볼을 키로 사용해 데이터 접근 가능

// 여러 코드에서 같은 객체에 접근할 때 충돌 방지
let id = Symbol("id"); // 해당 코드의 전용 심볼 생성
user[id] = "제3 스크립트 id 값";


let id = Symbol('id');
let user = {
    name:'KIM',
    [id]: 123 // 객체 안에서 심볼 키 사용할 때 대괄호 사용해야함
};

// global symbol registry
// Symbol.for(key);
// 이름이 key인 심볼이 없으면 새로운 심볼 생성하고 레지스트리에 저장 
// 있으면 동일한 심볼값 반환  
let g_id = Symbol.for('id'); // 전역 심볼 생성
let g_id_2 = Symbol.for('id'); // g_id와 동일한 값
alert(g_id == g_id_2);

// 전역 심볼 키 접근
alert(Symbol.keyFor(g_id)); // g_id의 키 반환 (id)

// 전역 심볼 생성
let sym = Symbol.for("name");
let sym2 = Symbol.for("id");

// 전역 심볼 키 접근
// 전역 레지스토리에 해당하는 이름을 찾아 반환
alert( Symbol.keyFor(sym) ); // name
alert( Symbol.keyFor(sym2) ); // id

// 전역 vs 일반 심볼
let globalSymbol = Symbol.for("name"); // 전역 심볼
let localSymbol = Symbol("name"); // 일반 심볼

alert( Symbol.keyFor(globalSymbol) ); // name, 전역 심볼 이름 반환
alert( Symbol.keyFor(localSymbol) ); // undefined, 전역 심볼이 아니기 때문에 
alert( localSymbol.description ); // name, description 프로퍼티로 이름 반환 가능