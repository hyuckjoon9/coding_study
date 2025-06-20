class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str1);
        for (int i = 0; i < str2.length(); i++) {
            sb.insert(2 * i + 1, str2.charAt(i));
        }
        String answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
}