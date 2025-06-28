import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sumArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();
            result = sumArr[endIdx] - sumArr[startIdx - 1];
            System.out.println(result);
        }
    }
}