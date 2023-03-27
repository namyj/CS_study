"""
문제: 베스트앨범
해결: sort 함수의 기준 파라미터
우선순위
1. 가장 많이 재생된 장르순
2. 장르 내 가장 많이 재생된 노래순
3. 고유번호가 낮은 노래
장르별로 두 노래만 선택 (포함되지 않는 노래가 존재할 수 있음)
"""

def solution(genres, plays):
    answer = []
    dictionary = {}
    gen_cnt = {}

    # 딕셔너리 생성
    for i in range(len(genres)):
        if genres[i] not in dictionary:
            dictionary[genres[i]] = [[plays[i], i]]
            gen_cnt[genres[i]] = plays[i]
        else:
            dictionary[genres[i]].append([plays[i], i])
            gen_cnt[genres[i]] += plays[i]

    # 내림차순 장르 리스트        
    gen_sort = sorted(gen_cnt.keys(), key=lambda x:-gen_cnt[x])

    for g in gen_sort:
        dictionary[g].sort(key=lambda x: (-x[0], x[1]))
        answer.extend(num for cnt, num in dictionary[g][:2])

    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

solution(genres, plays)