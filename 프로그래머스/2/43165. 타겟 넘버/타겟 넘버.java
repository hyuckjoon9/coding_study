class Solution {
    static int answer=0;
    public static int solution(int[] numbers, int target) {

        int sum = 0;
        dfs(numbers, 0, sum, target);
        return answer;
    }

    public static void dfs(int[] numbers, int index, int sum, int target) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, index + 1, sum + numbers[index], target);
        dfs(numbers, index + 1, sum - numbers[index], target);
    }
}