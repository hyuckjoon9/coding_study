import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int firstAbs = Math.abs(a);
            int secondAbs = Math.abs(b);

            if (firstAbs == secondAbs) return a > b ? 1 : -1;
            else return firstAbs - secondAbs;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            else pq.add(x);
        }
        System.out.println(sb);
    }
}