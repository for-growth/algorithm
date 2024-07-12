# 11:59 ~ 12:17
def solution(n, m, section):
    answer = 0

    start = 0

    for s in section:
        if start < s:
            answer += 1
            start = s + m - 1

    return answer

section = [2,3,6]
print(solution(8, 4, section))