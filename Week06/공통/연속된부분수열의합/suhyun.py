# 9:00 ~ 9:12
def solution(sequence, k):
    answer = []
    R, sums = -1, 0
    min_ans = len(sequence) + 1
    for L in range(len(sequence)):
        while R + 1 < len(sequence) and sums < k:
            R += 1
            sums += sequence[R]

        if sums == k:
            if min_ans > R - L + 1:
                min_ans = R - L + 1
                answer = [L, R]

        sums -= sequence[L]

    return answer

sequence = [1, 1, 1, 2, 3, 4, 5]
k = 5
print(solution(sequence, k))