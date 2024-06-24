def solution(sequence, k):
    answer = []
    R = 0
    sums = 0
    min_ans = 1e9

    for L in range(len(sequence)):
        while R < len(sequence) and sums < k:
            sums += sequence[R]
            R += 1

        if sums == k:
            if min_ans > R-L:
                answer = [L, R-1]
                min_ans = min(min_ans, R-L)
        sums -= sequence[L]
    return answer

sequence = [1, 1, 1, 2, 3, 4, 5]
print(solution(sequence, 5))