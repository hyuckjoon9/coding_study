import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double score = Integer.parseInt(st.nextToken());
            sum += score;
            if (score > max) max = score;
        }
        System.out.println(sum / (max * n) * 100);
    }
}