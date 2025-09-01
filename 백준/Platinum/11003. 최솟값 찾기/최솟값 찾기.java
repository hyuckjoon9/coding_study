import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Node> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (dq.isEmpty()) {
                dq.addLast(new Node(i, now));
            } else if (i - dq.getFirst().idx < L && dq.size() < L) {
                comp(now, i);
            } else {
                dq.removeFirst();
                comp(now, i);
            }
            bw.write(dq.getFirst().val + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void comp(int now, int i) {
        while (!dq.isEmpty() && dq.getLast().val > now) {
            dq.removeLast();
        }
        dq.addLast(new Node(i, now));
    }

    static class Node {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
