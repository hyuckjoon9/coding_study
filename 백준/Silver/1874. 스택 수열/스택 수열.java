import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isNo = false;

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (cur >= num) {
                while (cur >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (cur != stack.peek()) {
                    isNo = true;
                    break;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(isNo ? "NO" : sb.toString());
    }
}