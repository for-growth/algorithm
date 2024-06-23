def solution(name, yearning, photo):
    answer = []

    for p in photo:
        sum_val = 0
        for idx, n in enumerate(name):
            if n in p:
                sum_val += yearning[idx]
        answer.append(sum_val)
    return answer