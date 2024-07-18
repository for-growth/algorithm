# 1:09 ~ 1:27
sx, sy = 0, 0

dir = {"E" : (0,1), "S" : (1,0), "W" : (0, -1), "N" : (-1, 0)}

def solution(park, routes):
    answer = []

    for i, p in enumerate(park):
        for j, pp in enumerate(park[0]):
            if park[i][j] == 'S':
                sx, sy = i, j
                break

    for r in routes:
        direction, c = r.split(" ")
        nx, ny = sx, sy
        for i in range(int(c)):
            nx += dir[direction][0]
            ny += dir[direction][1]
            if nx < 0 or ny < 0 or nx >= len(park) or ny >= len(park[0]) or park[nx][ny] == 'X':
                nx, ny = sx, sy
                break
        sx, sy = nx, ny

    return [sx, sy]

park = ["OSO","OOO","OXO","OOO"]
routes = ["E 2","S 3","W 1"]
print(solution(park, routes))