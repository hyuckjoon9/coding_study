import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<Integer, String> ranks = new HashMap<>();
        HashMap<String, Integer> names = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            ranks.put(i, players[i]);
            names.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int prevRank = names.get(callings[i]);
            String prevName = ranks.get(prevRank - 1);

            int nextRank = names.get(prevName);
            names.put(prevName, prevRank);
            names.put(callings[i], nextRank);

            ranks.put(prevRank, prevName);
            ranks.put(nextRank, callings[i]);
        }
        return ranks.values().toArray(new String[0]);
    }
}