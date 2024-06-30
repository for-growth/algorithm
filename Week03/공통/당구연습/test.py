import math


def get_dist(x1, y1, x2, y2):
    result = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
    return result


def calc(sx, sy, ex, ey, m, n):
    up, down, left, right = float('inf'), float('inf'), float('inf'), float('inf')
    if not (sx == ex and sy > ey):
        down = get_dist(sx, -sy, ex, ey)
    if not (sx > ex and sy == ey):
        left = get_dist(-sx, sy, ex, ey)
    if not (sx == ex and sy < ey):
        up = get_dist(sx, 2*n-sy, ex, ey)
    if not (sx == ex and sy > ey):
        right = get_dist(2*m-sx, sy, ex, ey)
    return round(math.pow(min(up, down, left, right), 2))


def solution(m, n, startX, startY, balls):
    answer = [calc(startX, startY, endX, endY, m, n) for endX, endY in balls]
    return answer