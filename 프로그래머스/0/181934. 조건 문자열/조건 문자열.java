class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals("<") && n > m) return 0;
        else if (ineq.equals(">") && n < m) return 0;
        if (eq.equals("=") && n == m) return 1;
        else if (eq.equals("!") && n != m) return 1;
        return 1;
    }
}