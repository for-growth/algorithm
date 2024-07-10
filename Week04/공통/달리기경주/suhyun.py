def solution(players, callings):

    player_idx = {player: idx for idx, player in enumerate(players)}

    for call in callings:
        idx = player_idx[call] #3
        players[idx], players[idx - 1] = players[idx - 1], players[idx]

        player_idx[players[idx]] = idx
        player_idx[players[idx - 1]] = idx - 1

    return players

players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]
print(solution(players, callings))