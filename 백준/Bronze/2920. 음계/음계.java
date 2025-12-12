import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[8];
        for (int i = 0; i < 8; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("ascending");
        } else {
            for (int i = 0; i < arr2.length / 2; i++) {
                int tmp = arr2[i];
                arr2[i] = arr2[arr2.length - i - 1];
                arr2[arr2.length - i - 1] = tmp;
            }

            if (Arrays.equals(arr1, arr2)) {
                System.out.println("descending");
            } else {
                System.out.println("mixed");
            }

        }

    }
}