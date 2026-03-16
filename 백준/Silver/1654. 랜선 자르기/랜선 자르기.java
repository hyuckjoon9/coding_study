import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K + 1];

        int maxLan = Integer.MIN_VALUE;
        for (int i = 1; i <= K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            maxLan = Math.max(maxLan, lans[i]);
        }

        long left = 1;
        long right = maxLan;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int lan : lans) {
                sum += lan / mid;
            }

            if (sum >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}