import java.util.Scanner;

public class Main {
    static int[] g;
    static int n;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        g = new int[n];
        tracking(0);
        System.out.println(cnt);
    }

    static void tracking(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            g[row] = i;
            if (check(row)) {
                tracking(row + 1);
            }
        }
    }

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (g[i] == g[row]) return false;
            if (Math.abs(row - i) == Math.abs(g[row] - g[i])) return false;
        }
        return true;
    }
}