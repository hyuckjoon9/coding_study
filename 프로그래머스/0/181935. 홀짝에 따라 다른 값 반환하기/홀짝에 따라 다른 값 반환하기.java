class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= (int) Math.ceil((double) n / 2); i++) {
            if (n % 2 == 0) answer += Math.pow(2 * i, 2);
            else answer += (2 * i - 1);
        }
        return answer;
    }
}