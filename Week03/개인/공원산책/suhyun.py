sx, sy = 0, 0

dir = {"E":(0,1), "S":(1,0), "W":(0,-1), "N":(-1,0)}

def solution(park, routes):

    for i, row in enumerate(park):
        for j, col in enumerate(row):
            if col == 'S':
                sx, sy = i, j

    for route in routes:
        d, cnt = route.split(" ")
        nx, ny = sx, sy
        for i in range(int(cnt)):
            x, y = dir[d]
            nx += x
            ny += y


    answer = []
    return answer

