import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int idx = K;
        int mul1 = 1;
        int mul2 = 1;
        for (int i = 0; i < idx; i++) {
            mul1 *= N--;
            mul2 *= K--;
        }
        System.out.println(mul1 / mul2);
    }
}