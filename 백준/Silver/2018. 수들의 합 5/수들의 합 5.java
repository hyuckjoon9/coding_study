import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 1, count = 1;
        int startIdx = 1, endIdx = 1;

        while (endIdx != n) {
            if (sum > n) {
                sum -= startIdx;
                startIdx++;
            } else if (sum < n) {
                endIdx++;
                sum += endIdx;
            } else {
                count++;
                endIdx++;
                sum += endIdx;
            }
        }
        System.out.println(count);
    }
}
