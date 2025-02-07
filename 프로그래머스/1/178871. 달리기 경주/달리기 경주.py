def solution(players, callings):
    player_to_index = {player:i for i, player in enumerate(players)}

    for call in callings:
        cur_idx = player_to_index[call]
        
        prev_idx = cur_idx - 1
        
        players[prev_idx], players[cur_idx] = players[cur_idx], players[prev_idx]

        player_to_index[players[prev_idx]] = prev_idx
        player_to_index[players[cur_idx]] =  cur_idx
        
    return players