import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        visited = new boolean[n + 1];
        tracking(0);
    }

    static void tracking(int len) {
        if (len == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[len] = i;
                tracking(len + 1);
                visited[i] = false;
            }
        }
    }
}