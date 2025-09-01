import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    static Deque<Node> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.getLast().val > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, now));

            if (dq.getFirst().idx <= i - L) dq.removeFirst();

            sb.append(dq.getFirst().val).append(' ');
        }
        System.out.println(sb.toString());
    }
}
