def solution(sequence, k):
    answer = []
    R, sums = 0, 0
    min_ans = len(sequence) + 1

    for L in range(len(sequence)):
        while R + 1 <= len(sequence) and sums < k:
            sums += sequence[R]
            R += 1

        if sums == k:
            if min_ans > R-L:
                min_ans = R-L
                ans = R - L
                answer = [L, R-1]

        sums -= sequence[L]

    return answer

sequence = [1, 1, 1, 2, 3, 4, 5]
print(solution(sequence, 5))