import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 2) {
            System.out.println(N);
            return;
        }

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] cnt = new int[10];

        int left = 0, answer = 0, kind = 0;
        for (int right = 0; right < N; right++) {
            if (cnt[arr[right]] == 0) kind++;
            cnt[arr[right]]++;

            while (kind > 2) {
                cnt[arr[left]]--;
                if (cnt[arr[left]] == 0) kind--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);

    }
}