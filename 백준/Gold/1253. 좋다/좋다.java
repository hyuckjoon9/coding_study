import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int startIdx = 0;
            int endIdx = n - 1;
            while (startIdx < endIdx) {
                int sum = arr[startIdx] + arr[endIdx];
                if (sum < arr[i]) startIdx++;
                else if (sum > arr[i]) endIdx--;
                else {
                    if (startIdx != i && endIdx != i) {
                        count++;
                        break;
                    } else if (startIdx == i) startIdx++;
                    else if (endIdx == i) endIdx--;
                }
            }
        }
        System.out.println(count);
    }
}
