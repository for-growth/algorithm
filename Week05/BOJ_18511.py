import sys


sys.setrecursionlimit(10**6)
N, K = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))
cur = 0
org_digits = len(str(N))
pre_digit = N
digits = [0 for _ in range(org_digits)]

for i in range(org_digits-1, -1, -1):
    digits[i] = pre_digit % 10
    pre_digit = pre_digit // 10

big_nums = [[num for num in numbers if num <= digits[i]] for i in range(org_digits)]
for i, nums in enumerate(big_nums):
    cur += (nums[-1] * (10**(org_digits-1-i)))

print(cur)










