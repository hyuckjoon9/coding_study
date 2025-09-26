import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int num, int len) {
        if (len == n) {
            if (isPrime(num)) System.out.println(num);
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrime(10 * num + i)) dfs(10 * num + i, len + 1);
        }
    }

    static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        if (num < 2) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}