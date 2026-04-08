import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                land[i][j] = num;
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHigh = Integer.MIN_VALUE;
        for (int h = 0; h <= 256; h++) {
            int remove = 0;
            int inventory = B;
            int needBlock = 0;
            int time = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (land[i][j] > h) {
                        remove = land[i][j] - h;
                        inventory += remove;
                        time += (land[i][j] - h) * 2;
                    } else if (land[i][j] < h) {
                        needBlock += h - land[i][j];
                        time += h - land[i][j];
                    }
                }
            }

            if (inventory < needBlock) continue;

            if (minTime >= time) {
                maxHigh = Math.max(maxHigh, h);
            }
            minTime = Math.min(minTime, time);

        }

        System.out.println(minTime + " " + maxHigh);
    }
}