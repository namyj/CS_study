"""
문제: 전화번호 목록
- 그냥 in 사용시 접두사가 아닌, 문자열 내부에 포함 된 것도 False로 출력 
"""

# 내 풀이
# 한 문제 에러 및 시간 초과
"""
- 문제를 틀리는 이유??
"""
def solution(phone_book):
    answer = True
    sort_list = sorted(phone_book)
    
    for j in range(len(sort_list)//2+1):
        key = sort_list[j]

        for i in range(j+1, len(sort_list)):
            if key == sort_list[i][0:len(key)]:
                answer = False
                return answer

    return answer

phone_book = ["11", "167", "1195524421"]	
print(sorted(phone_book))
print(solution(phone_book))


# 솔루션
def solution(phone_book):
    answer = True
    phone_book.sort()

    for i in range(len(phone_book)-1):
        if phone_book[i] == phone_book[i+1][:len(phone_book[i])]:
            answer = False
            break
    return answer