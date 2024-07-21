def solution(name, yearning, photo):
    answer = []

    score = {}
    for idx, n in enumerate(name):
        score[n] = yearning[idx]

    for p in photo:
        s = 0
        for pp in p:
            if pp in score:
                s += score[pp]
        answer.append(s)

    return answer

name = ["may", "kein", "kain", "radi"]
yearning = [5, 10, 1, 3]
photo = [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]
print(solution(name, yearning, photo))