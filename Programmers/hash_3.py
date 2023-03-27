"""
문제: 위장
해결: 딕셔너리

솔루션:
만약 top 3, bottom 2 라면, 
경우의 수는 (top 3 + bottom을 입지 않을때 1) x (bottom 2 + top을 입지 않을때 1) = 6
6 - (top과 bottom을 모두 안입은 경우는 제외) = 5
"""
def solution(clothes):
    answer = 1
    dictionary = {}

    for i in range(len(clothes)):
        if clothes[i][1] not in dictionary:
            dictionary[clothes[i][1]] = 1
        else:
            dictionary[clothes[i][1]] += 1
    print(dictionary)

    keys = list(dictionary.keys())
    for i in range(len(keys)):
        answer *= (dictionary[keys[i]] + 1) 
    answer -= 1

    return answer

# clothes = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
solution(clothes)