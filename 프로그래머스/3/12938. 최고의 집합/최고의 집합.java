import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int base = s / n;
        int remain = s % n;
        int[] answer = new int[n];
        Arrays.fill(answer, base);

        for (int i = n - 1; i >= n - remain; i--) {
            answer[i]++;
        }
        return answer;
    }
}