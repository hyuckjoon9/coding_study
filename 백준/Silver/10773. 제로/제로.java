import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                dq.pollFirst();
            } else {
                dq.push(number);
            }
        }
        if (dq.isEmpty()) {
            System.out.println(0);
            return;
        }

        int sum = 0;
        while (!dq.isEmpty()) {
            sum += dq.pollLast();
        }
        System.out.println(sum);
    }
}