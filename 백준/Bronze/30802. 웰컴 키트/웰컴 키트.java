import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int shirtBundle = 0;
        for (int i = 0; i < arr.length; i++) {
            shirtBundle += (int) Math.ceil((double) arr[i] / T);
        }

        int penBundle = N / P;
        int penPiece = N % P;
        System.out.println(shirtBundle);
        System.out.println(penBundle + " " + penPiece);
    }
}