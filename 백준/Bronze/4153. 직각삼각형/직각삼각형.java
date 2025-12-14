import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) return;

            int max = Math.max(a, b);
            int min1 = Math.min(a, b);
            int min2 = Math.min(max, c);
            max = Math.max(max, c);

            if (min1 * min1 + min2 * min2 == max * max) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }


        }

    }
}