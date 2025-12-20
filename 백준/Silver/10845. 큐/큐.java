import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[N];

        int front = 0;
        int rear = 0;

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                queue[rear++] = x;
            }
            else if (cmd.equals("pop")) {
                if (front == rear) sb.append(-1).append('\n');
                else sb.append(queue[front++]).append('\n');
            }
            else if (cmd.equals("size")) {
                sb.append(rear - front).append('\n');
            }
            else if (cmd.equals("empty")) {
                sb.append(front == rear ? 1 : 0).append('\n');
            }
            else if (cmd.equals("front")) {
                if (front == rear) sb.append(-1).append('\n');
                else sb.append(queue[front]).append('\n');
            }
            else if (cmd.equals("back")) {
                if (front == rear) sb.append(-1).append('\n');
                else sb.append(queue[rear - 1]).append('\n');
            }
        }

        System.out.print(sb);
    }
}
