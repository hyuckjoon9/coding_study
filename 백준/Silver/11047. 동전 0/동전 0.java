import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.addLast(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            int coin = dq.pollLast();

            if (coin > target) continue;

            while (coin <= target) {
                target -= coin;
                result++;
            }
        }

        System.out.println(result);
    }
}