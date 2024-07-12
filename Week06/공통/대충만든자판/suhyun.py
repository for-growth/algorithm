# 12:18 ~ 12:38
# find, 찾으려고 하는 특정 문자가 없다면 -1 반환
# index, 찾으려고 하는 특정 문자가 없다면 에러 반환
def solution(keymap, targets):
    answer = []

    for t in targets:
        s = 0
        for munza in t:
            count = 101
            for k in keymap:
                if munza in k:
                    count = min(count, k.index(munza) + 1)
            if count == 101:
                s = -1
                break
            else:
                s += count
        answer.append(s)
    return answer

keymap = ["ABACD", "BCEFD"]
targets = ["ABCD","AABB"]
print(solution(keymap, targets))