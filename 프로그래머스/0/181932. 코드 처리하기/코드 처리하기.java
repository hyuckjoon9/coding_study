class Solution {
    public String solution(String code) {
        boolean mode = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '1') {
                mode = !mode;
                continue;
            }
            if (i % 2 == (mode ? 1 : 0)) {
                result.append(ch);
            }
        }
        return result.length() == 0 ? "EMPTY" : result.toString();
    }
}