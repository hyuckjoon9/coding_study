import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sumArr = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) sumArr[i] = sc.nextInt();
            else sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            int startIdx = sc.nextInt() - 1;
            int endIdx = sc.nextInt() - 1;
            if (startIdx == 0) result = sumArr[endIdx];
            else result = sumArr[endIdx] - sumArr[startIdx - 1];
            System.out.println(result);
        }
    }
}