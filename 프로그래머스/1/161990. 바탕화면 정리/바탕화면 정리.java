class Solution {
    public int[] solution(String[] wallpaper) {
        int[] max = {49, 49, 0, 0};

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (max[0] > i) max[0] = i;
                    if (max[1] > j) max[1] = j;
                    if (max[2] < i + 1) max[2] = i + 1;
                    if (max[3] < j + 1) max[3] = j + 1;
                }
            }
        }
        return max;
    }
}