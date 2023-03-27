"""
문제: 완주하지 못한 선수
- 동명 이인 존재
    - set 사용 불가능
- 리스트 정렬 후, 동일한 위치의 원소 비교
- 다르면 part 원소 리턴
- 정렬된 리스트의 맨 마지막에 결과가 존재하는 경우 처리
"""
def solution(participant, completion):
    answer = ''
    part = sorted(participant) # 참가자 리스트
    comp = sorted(completion) # 완주자 리스트

    for i in range(len(comp)):
        if comp[i] != part[i]:
            answer = part[i]
            return answer
    answer = part[-1]
    return answer

participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]

result = solution(participant, completion)
print(result)