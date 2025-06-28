import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int startIdx = 0;
        int endIdx = n - 1;
        int answer = 0;
        while (startIdx != endIdx) {
            int sum = arr[startIdx] + arr[endIdx];
            if (sum > m) endIdx--;
            else if (sum < m) startIdx++;
            else {
                endIdx--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}