import heapq


def convert_time(str_time):
    return int(str_time[:2])*60 + int(str_time[3:])


def solution(book_time):
    times = dict()
    for book in book_time:
        start, end = convert_time(book[0]), convert_time(book[1])+10
        for t in range(start, end):
            if times.get(t) is None:
                times[t] = 1
            else:
                times[t] += 1

    return max(times.values())



if __name__ == '__main__':
    tc1 = [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
    tc2 = [["09:10", "10:10"], ["10:20", "12:20"]]
    tc3 = [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]
    tc4 = [["09:00", "12:30"], ["12:40", "13:30"], ["13:29", "13:30"]]
    tc5 = [["00:00", "00:07"], ["00:01", "00:08"], ["00:02", "00:09"], ["10:26", "10:41"]]
    tc6 = [["1:00", "2:01"], ["2:10", "3:00"], ["3:10", "4:00"]]
    print(solution(tc1))
