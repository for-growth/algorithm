# 11:52 ~ 11:58
def solution(wallpaper):
    answer = []
    sx, sy, ex, ey = len(wallpaper), len(wallpaper[0]), 0, 0

    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                sx = min(sx, i)
                sy = min(sy, j)
                ex = max(ex, i)
                ey = max(ey, j)

    return [sx, sy, ex + 1, ey + 1]

wallpaper = [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]
print(solution(wallpaper))