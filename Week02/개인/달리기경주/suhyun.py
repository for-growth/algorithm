def solution(players, callings):
    answer = []

    player_idx = {player: idx for idx, player in enumerate(players)}

    for call in callings:
        idx = player_idx[call] # kai의 현재 등수 (3등:인덱스기준)

        players[idx - 1], players[idx] = players[idx], players[idx - 1]

        player_idx[players[idx]] = idx
        player_idx[players[idx-1]] = idx - 1

    return players

players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]
print(solution(players, callings))