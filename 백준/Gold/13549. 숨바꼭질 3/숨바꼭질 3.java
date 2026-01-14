import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100_001];
        Arrays.fill(dist, -1);
        dist[N] = 0;
        bfs();
    }

    public static void bfs() {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(N);

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }

            int[] d = {cur, -1, 1};

            for (int i = 0; i < 3; i++) {
                int nx = cur + d[i];


                if (nx < 0 || nx > 100_000) continue;
                if (dist[nx] != -1) continue;

                if (i == 0) {
                    dist[nx] = dist[cur];
                    dq.addFirst(nx);
                } else {
                    dist[nx] = dist[cur] + 1;
                    dq.addLast(nx);
                }
            }
        }
    }

}