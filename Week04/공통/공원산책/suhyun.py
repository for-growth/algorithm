sx, sy = 0, 0

dir = {"E" : (0,1), "S" : (1,0), "W" : (0,-1), "N" : (-1,0)}

def solution(park, routes):
    answer = []

    for i, row in enumerate(park):
        for j, col in enumerate(row):
            if col == 'S':
                sx, sy = i, j

    for route in routes:
        d, cnt = route.split(" ") # E 2
        nx, ny = sx, sy
        for i in range(int(cnt)):
            x, y = dir[d]
            nx += x
            ny += y
            if nx < 0 or ny < 0 or nx >= len(park) or ny >= len(park[0]) or park[nx][ny] == 'X':
                nx, ny = sx, sy
                break
        sx = nx
        sy = ny

    return [sx, sy]

print(solution)