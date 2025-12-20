import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N]; // 최대 N번 push
        int top = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                int x = Integer.parseInt(line.split(" ")[1]);
                stack[top++] = x;
            } 
            else if (line.equals("pop")) {
                if (top == 0) sb.append(-1).append('\n');
                else sb.append(stack[--top]).append('\n');
            } 
            else if (line.equals("size")) {
                sb.append(top).append('\n');
            } 
            else if (line.equals("empty")) {
                sb.append(top == 0 ? 1 : 0).append('\n');
            } 
            else if (line.equals("top")) {
                if (top == 0) sb.append(-1).append('\n');
                else sb.append(stack[top - 1]).append('\n');
            }
        }

        System.out.print(sb);
    }
}
