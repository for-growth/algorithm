from collections import deque


def bfs(start_y, start_x, end_y, end_x, maps):
    # 상 하 좌 우
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    # 세로, 가로
    N, M = len(maps), len(maps[0])
    visited = [[False for _ in range(M)] for __ in range(N)]
    dq = deque()
    dq.append([start_y, start_x, 0])

    while dq:
        cy, cx, cd = dq.popleft()
        if cy == end_y and cx == end_x:
            return cd
        for m in range(4):
            ny, nx = cy + dy[m], cx + dx[m]
            if 0 <= ny < N and 0 <= nx < M and maps[ny][nx] != 'X':
                if not visited[ny][nx]:
                    visited[ny][nx] = True
                    dq.append([ny, nx, cd + 1])

    return -1


def solution(maps):
    n, m = len(maps), len(maps[0])
    # 시작, 레버, 종착지의 x, y 좌표
    sy, sx, ly, lx, ey, ex = 0, 0, 0, 0, 0, 0
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'S':
                sy, sx = i, j
            elif maps[i][j] == 'E':
                ey, ex = i, j
            elif maps[i][j] == 'L':
                ly, lx = i, j

    path1 = bfs(sy, sx, ly, lx, maps)
    path2 = bfs(ly, lx, ey, ex, maps)
    if path1 == -1 or path2 == -1:
        return -1
    return path1 + path2


if '__main__' == __name__:
    tc1 = ["SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"]
    tc2 = ["LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"]
    print(solution(tc2))
