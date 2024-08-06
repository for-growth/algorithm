# s = 'zzzz', skip = 'a', index = 1
alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
         'w', 'x', 'y', 'z']


def solution(s, skip, index):
    answer = ''

    for word in s:
        chars = []
        next = 1
        current_word = word
        while (len(chars) < index):
            # ord : 유니코드 정수 반환, a = 97
            next_word = chr(ord(current_word) + next)
            if next_word > 'z':
                next_word = alpha[(alpha.index(current_word) + next) % 26]

            next += 1
            if next_word in skip:
                continue
            chars.append(next_word)
        # print(chars)
        answer += chars[len(chars) - 1]

    return answer