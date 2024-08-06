# 9:29 ~
# from collection import deque
# 왼쪽 제거시, popleft()
from collections import deque
def solution(cards1, cards2, goal):
    answer = 'Yes'
    c1 = deque(cards1)
    c2 = deque(cards2)

    for g in goal:
        a, b = False, False
        if g == c1[0]:
            c1.popleft()
            a = True

        if g == c2[0]:
            c2.popleft()
            b = True

        if a == False and b == False:
            answer = 'No'
            break

    return answer