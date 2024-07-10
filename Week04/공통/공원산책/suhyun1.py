sx, sy = 0, 0
dir = {"E" : (0,1), "S" : (1,0), "W" : (0,-1), "N" : (-1, 0)}

def solution(park, routes):
    answer = []

    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == 'S':
                sx, sy = i, j
                break

    for r in routes:
        d, cnt = r.split(" ")
        nx, ny = sx, sy
        for i in range(int(cnt)):
            nx += dir[d][0]
            ny += dir[d][1]
            if nx < 0 or ny < 0 or nx >= len(park) or ny >= len(park[0]) or park[nx][ny] == 'X':
                nx = sx
                ny = sy
                break
        sx, sy = nx, ny

    return [sx, sy]

park = ["SOO","OOO","OOO"]
routes = ["E 2","S 2","W 1"]
print(solution(park, routes))