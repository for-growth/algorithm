import math
def solution(r1, r2):
    answer = 0

    for r in range(1, r2):
        if r < r1:
            answer += (getDotCnt(r, r2, "r2") - getDotCnt(r, r1, "r1"))
        else:
            answer += getDotCnt(r, r2, "r2")

    answer *= 4
    answer += (r2 - r1 + 1) * 4
    return answer

def getDotCnt(r, circle, s):
    y = math.sqrt(circle ** 2 - r ** 2)
    cnt_y = int(y)
    if s == "r1" and y == cnt_y:
        return cnt_y - 1
    return cnt_y

print(solution(2, 3))