# 문자열에서 특정 문자를 찾고자 할때, 문자열.find(특정문자)
def solution(keymap, targets):
    answer = []

    for t in targets:
        b = 0
        for character in t:
            a = 101
            for k in keymap:
                # print(k)
                if k.find(character) == -1:
                    continue
                a = min(k.find(character), a)
            if a == 101:
                a = -1
                b = -1
                break
            else:
                b += (a + 1)
                # print(a + 1)
        answer.append(b)
    return answer

print(solution(	["ABACD", "BCEFD"], ["ABCD", "AABB"]))