class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int endOfRoller = 0;

        for (int point : section) {
            if (point <= endOfRoller) {
                continue; // 이미 칠해진 구간이면 넘긴다
            }
            count++; // 새로운 롤러칠
            endOfRoller = point + m - 1; // 새로 롤러칠한 구간의 끝
        }

        return count;
    }
}