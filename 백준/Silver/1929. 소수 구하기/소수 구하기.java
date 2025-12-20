import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) sb.append(i).append("\n");
        }
        System.out.println(sb);

    }

    public static boolean isPrime(int x) {
        if (x == 2) return true;
        if (x < 2) return false;
        if (x % 2 == 0) return false;

        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}