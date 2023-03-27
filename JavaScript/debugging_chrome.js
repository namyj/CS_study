// Chrome을 사용한 디버깅 방법
function Hello(name) {
    let phrase = `hello ${name}`;

    debugger; // 이 지점에서 실행 멈춤
    sayHi(phrase);
} 

function sayHi(phrase) {
    alert(`**${phrase}**`);
}

// log
// 특정 값을 콘솔창에 출력가능
for (let i=0; i<5 ; i++){
    console.log("Number", i);
}