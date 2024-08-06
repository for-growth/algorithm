from collections import deque


def solution(cards1, cards2, goal):
    # answer = ''
    a = True

    c1 = deque(cards1)
    c2 = deque(cards2)

    for g in goal:
        b = True
        if c1:
            if c1[0] == g:
                c1.popleft()
                b = False
        if c2:
            if c2[0] == g:
                c2.popleft()
                b = False

        if b == True:
            # answer = 'No'
            a = False
            break

    return "Yes" if a == True else "No"

cards1 = ["i", "drink", "water"]
cards2 = ['a', 'b', 'c', 'd', 'e' , "want", "to"]
goal = ["i", "want", "to", "drink", "water"]
print(solution(cards1, cards2, goal))