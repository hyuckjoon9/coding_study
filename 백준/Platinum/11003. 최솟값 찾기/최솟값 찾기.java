import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (dq.isEmpty()) dq.addLast(new Node(i, cur));
            else {
                // 슬라이딩 윈도우 범위가 L을 넘어갈 때
                if (i - dq.getFirst().index >= l) {
                    dq.removeFirst();
                }

                // 마지막 value가 cur보다 클 때
                while (!dq.isEmpty() && dq.getLast().value > cur) {
                    dq.removeLast();
                }

                dq.addLast(new Node(i, cur));
            }

            sb.append(dq.getFirst().value).append(' ');
        }
        System.out.println(sb);
    }

    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}