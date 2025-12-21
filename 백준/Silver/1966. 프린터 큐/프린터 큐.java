import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<Node> dq = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                pq.add(num);
                Node node = new Node(i, num);
                dq.addLast(node);
            }

            int printOrder = 1;

            while (!dq.isEmpty()) {
                Node cur = dq.pollFirst();
                if (cur.order == M && cur.value == pq.peek()) {
                    sb.append(printOrder).append("\n");
                    break;
                }

                if (cur.value == pq.peek()) {
                    printOrder++;
                    pq.poll();
                } else {
                    dq.addLast(cur);
                }
            }
        }
        System.out.println(sb);

    }
}

class Node {
    int order;
    int value;

    Node(int order, int value) {
        this.order = order;
        this.value = value;
    }
}