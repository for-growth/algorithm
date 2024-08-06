def solution(n, m, section):
    answer = 0
    start = 0
    for s in section:
        if start <= s:
            start = s + m
            answer += 1

    return answer

print(solution(4, 1, [1,2,3,4]))