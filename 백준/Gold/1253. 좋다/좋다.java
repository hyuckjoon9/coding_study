import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int startIdx = 0;
            int endIdx = n - 1;
            int find = (int) arr[i];
            while (startIdx < endIdx) {
                if (startIdx == i) {
                    startIdx++;
                    continue;
                } else if (endIdx == i) {
                    endIdx--;
                    continue;
                }
                int sum = (int) (arr[startIdx] + arr[endIdx]);
                if (sum > find) endIdx--;
                else if (sum < find) startIdx++;
                else {
                    answer++;
                    break;
                }
            }
        }
        sc.close();
        System.out.println(answer);
    }
}