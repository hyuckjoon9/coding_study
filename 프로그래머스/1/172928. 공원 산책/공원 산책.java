
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int startW = 0;
        int startH = 0;
        int maxW = park[0].length() - 1;
        int maxH = park.length - 1;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char c = park[i].charAt(j);
                if (c == 'S') {
                    startH = i;
                    startW = j;
                    break;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            char op = routes[i].charAt(0);
            int n = routes[i].charAt(2) - '0';
            int tempW = startW;
            int tempH = startH;
            boolean isTrue = true;
            for (int j = 0; j < n; j++) {
                if (op == 'E') {
                    tempW++;
                    if (tempW > maxW || tempH > maxH || tempW < 0 || tempH < 0) {
                        isTrue = false;
                        break;
                    } else if (park[tempH].charAt(tempW) == 'X') {
                        isTrue = false;
                        break;
                    }
                } else if (op == 'S') {
                    tempH++;
                    if (tempW > maxW || tempH > maxH || tempW < 0 || tempH < 0) {
                        isTrue = false;
                        break;
                    } else if (park[tempH].charAt(tempW) == 'X') {
                        isTrue = false;
                        break;
                    }
                } else if (op == 'W') {
                    tempW--;
                    if (tempW > maxW || tempH > maxH || tempW < 0 || tempH < 0) {
                        isTrue = false;
                        break;
                    } else if (park[tempH].charAt(tempW) == 'X') {
                        isTrue = false;
                        break;
                    }
                } else if (op == 'N') {
                    tempH--;
                    if (tempW > maxW || tempH > maxH || tempW < 0 || tempH < 0) {
                        isTrue = false;
                        break;
                    } else if (park[tempH].charAt(tempW) == 'X') {
                        isTrue = false;
                        break;
                    }
                }
                if (!isTrue) break;
            }
            if (isTrue) {
                startW = tempW;
                startH = tempH;
            }
        }
        return new int[]{startH, startW};
    }
}