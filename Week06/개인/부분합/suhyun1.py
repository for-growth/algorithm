import sys
si = sys.stdin.readline
n, s = list(map(int, si().readline))
a = list(map(int, si().split()))
R, sum, ans = -1, 0, 0
for L in range(n):
    while R + 1 < n and sum < s:
        R += 1
        sum += a[R]
    if sum == s:
        ans += 1

    sum -= a[L]

print(ans)