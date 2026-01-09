import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static int K;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        index = 100_000;

        dist = new int[index + 1];
        Arrays.fill(dist, -1);
        dist[N] = 0;

        bfs(N);
    }

    public static void bfs(int x) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(x);

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            int[] dx = {-1, 1, cur};

            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx = cur + dx[i];

                if (nx < 0 || nx > index) continue;
                if (dist[nx] != -1) continue;
                dist[nx] = dist[cur] + 1;
                dq.addLast(nx);
            }
        }
    }
}