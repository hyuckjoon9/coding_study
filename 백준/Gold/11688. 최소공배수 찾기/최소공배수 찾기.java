import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        long x = lcm(a, b);
        if (L % x != 0) {
            System.out.println(-1);
            return;
        }

        long k = L / x;
        long answer = Long.MAX_VALUE;
        for (long d = 1; d * d <= x; d++) {
            if (x % d != 0) continue;

            long d1 = d;
            long d2 = x / d;


            if (x % d1 == 0 && gcd(x / d1, k) == 1) {
                answer = Math.min(answer, k * d1);
            }

            if (d1 != d2 && x % d2 == 0 && gcd(x / d2, k) == 1) {
                answer = Math.min(answer, k * d2);
            }
        }
        System.out.println(answer);

    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}