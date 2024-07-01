from collections import *
import heapq


def solution(plans):
    answer = []
    buffer = []
    for plan in plans:
        time, minute = map(int, plan[1].split(":"))
        plan[1] = time * 60 + minute
        plan[2] = int(plan[2])
    plans.sort(key=lambda x: x[1])
    print(plans)
    plans = deque(plans)

    while plans:
        cs, ct, cd = plans.popleft()
        # 플랜에서 마지막 과목이라면 그냥 끝냄
        if not plans:
            answer.append(cs)
            # 끝내고 버퍼에 남은 과목들 순서대로 끝냄
            while buffer:
                ls, ld = buffer.pop()
                answer.append(ls)
        # 다음 과목도 있으면 다음 과목 시작시간과 현과목 남은시각 비교
        else:
            left = plans[0][1] - ct
            buffer.append([cs, cd])
            while buffer and left > 0:
                buffer[-1][1] -= left
                if buffer[-1][1] <= 0:
                    answer.append(buffer[-1][0])
                    left = buffer[-1][1] * -1
                    buffer.pop()
                else:
                    left = 0
                    break

    return answer


if __name__ == '__main__':
    plans1 = [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]
    """
    1. music을 꺼내 10분 진행하고 버퍼에 넣음 - 30분 남음
    2. 컴퓨터 꺼내 10분 진행하고 버퍼에 넣음 - 90분 남음
    3. 과학 꺼내 50분 진행하고 끝냄 - 810분째고 30분 남았으니 최근에 넣은 컴퓨터 꺼냄
    4. 컴퓨터 30분 진행하고 다시 넣음 - 60분 남음
    5. 역사 꺼내서 30분간 진행하고 끝냄 - 870분
    6. 최근에 넣은 컴퓨터 꺼내서 끝냄 - 60분 소모
    7. 그 다음 최근에 넣은 음악 꺼내어 끝냄 - 30분 소모
    8. 과목도 비었고 버퍼도 비었으면 종료 
    """
    plans2 = [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]
    plans3 = [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]
    print(solution(plans3))
