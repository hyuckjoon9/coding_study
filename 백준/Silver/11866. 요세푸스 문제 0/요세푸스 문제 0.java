import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<Integer>();

        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K; j++) {
                int num = dq.pollFirst();
                dq.addLast(num);
            }
            int out = dq.pollFirst();
            sb.append(out);
            if (i != N - 1) {
                sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);

    }
}