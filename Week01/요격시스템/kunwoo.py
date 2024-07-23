def solution(targets):
    # e, 요격 끝점 순으로 정렬하기
    targets.sort(key=lambda x: (x[1], x[0]))

    # 초기 미사일
    answer = 0

    # 요격 위치를 저장함
    ce = 0

    # 모든 미사일 정보에서
    for target in targets:
        # 현재 요격 끝점이 다음 요격대상의 시작점 왼쪽이거나 요격 불가능한 시작점이라면
        if ce <= target[0]:
            # 미사일을 하나 추가하고
            answer += 1
            # 현재 요격점을 요격 끝점으로 이동
            # 끝점은 요격 불가능한 위치이므로, 다음 시작점과 겹치면 새로 미사일을 추가하게 됨
            # 다음 시작점의 우측에 있다면 현재 요격 위치가 다음 시작점 ~ 현 끝점의 정수-실수 범위라는 뜻
            ce = target[1]

    return answer
