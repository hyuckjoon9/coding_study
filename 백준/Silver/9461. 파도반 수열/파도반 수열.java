import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] ns;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        ns = new int[t + 1];
        int max = 0;
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            ns[i] = n;
            max = Math.max(n, max);
        }

        long[] p = new long[max + 1];

        for (int i = 1; i <= 5; i++) {
            if (i == 1) p[i] = 1;
            else if (i == 2) p[i] = 1;
            else if (i == 3) p[i] = 1;
            else if (i == 4) p[i] = 2;
            else p[i] = 2;

            if (max == i) {
                getResult(p);
                System.out.println(sb);
                return;
            }
        }


        int firstIdx = 1;
        int secondIdx = 5;
        for (int i = 1; i < ns.length; i++) {
            if (p[ns[i]] != 0) {
                sb.append(p[ns[i]]).append("\n");
                continue;
            }

            while (secondIdx < ns[i]) {
                p[secondIdx + 1] = p[firstIdx++] + p[secondIdx++];
            }
            sb.append(p[ns[i]]).append("\n");
        }
        System.out.print(sb);
    }

    public static void getResult(long[] p) {
        for (int i = 0; i < ns.length; i++) {
            sb.append(p[ns[i]]).append("\n");
        }

    }
}