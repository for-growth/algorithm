def solution(targets):
    answer = 0

    sorted_targets = sorted(targets, key=lambda x: (x[1]))
    # print(sorted_targets)

    start = 0
    for t in sorted_targets:
        if start <= t[0]:
            start = t[1]
            answer += 1

    return answer

targets = [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
print(solution(targets))