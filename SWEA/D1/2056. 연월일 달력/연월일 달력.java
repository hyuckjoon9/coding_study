import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String line = br.readLine().trim();
            String out = "-1";

            int year = Integer.parseInt(line.substring(0, 4));
            int month = Integer.parseInt(line.substring(4, 6));
            int day = Integer.parseInt(line.substring(6, 8));

            if (0 < month && month <= 12) {
                int maxDay = DAYS[month - 1];
                if (0 < day && day <= maxDay) {
                    out = String.format("%04d/%02d/%02d", year, month, day);
                }
            }
            sb.append('#').append(i + 1).append(' ').append(out).append('\n');
        }
        System.out.println(sb);
    }
}