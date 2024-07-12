# 1:00 ~ 1:12
def solution(players, callings):
    answer = []

    players_idx = {players: idx for idx, players in enumerate(players)}

    for c in callings:
        current_grade = players_idx[c]
        prev_name = players[current_grade - 1]

        players_idx[c], players_idx[prev_name] = current_grade - 1, current_grade

        players[current_grade], players[current_grade - 1] = prev_name, c

    return players

players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]
print(solution(players, callings))