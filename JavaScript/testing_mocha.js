// test 자동화

// specification

describe("pow", function(){
    it("주어진 숫자 n의 제곱", function(){
        assert.equal(pow(2,3), 8);
    });
});


/*
[개발 순서]
1. 명세서 초안 작성 (기본 테스트)
2. 명세서 초안에 따라 코드 작성
3. Mocha 테스트 프레임워크를 사용해 명세서 실행
4. 작성한 코드가 모든 테스트를 통과할 때까지 수정
5. 명세서에 테스트할 유스 케이스 추가
6. 에러가 없을 때까지 코드 수정 반복
*/
describe("title", function(){
    it("use case specification", function(){
        // use case test function
        assert.equal(value1, value2) // 인수끼리 비교했을때, 다르면 -> error
    });
});
