import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                answer[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) answer[stack.pop()] = -1;

        for (int v : answer) {
            sb.append(v).append(' ');
        }
        System.out.println(sb);
    }
}