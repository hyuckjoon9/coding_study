import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int operCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '+' || line.charAt(i) == '-') operCount++;
        }


        int tokenStart = 0;
        int beforSub = 0;
        boolean hasSub = false;
        int afterSub = 0;

        for (int i = 0; i < line.length(); i++) {
            if (!hasSub && line.charAt(i) == '+') {
                String token = line.substring(tokenStart, i);
                tokenStart = i + 1;

                beforSub += Integer.parseInt(token);
                operCount--;
            } else if (line.charAt(i) == '-' || line.charAt(i) == '+') {
                String token = line.substring(tokenStart, i);
                tokenStart = i + 1;

                if (!hasSub) {
                    beforSub += Integer.parseInt(token);
                    hasSub = true;
                } else {
                    afterSub += Integer.parseInt(token);
                }
                operCount--;
            }


            if (operCount <= 0) {
                if (!hasSub) {
                    String token = line.substring(tokenStart);

                    beforSub += Integer.parseInt(token);
                } else {
                    String token = line.substring(tokenStart);

                    afterSub += Integer.parseInt(token);
                }
                break;
            }
        }
        System.out.println(beforSub - afterSub);
    }
}