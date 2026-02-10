import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, int[]> dir = new HashMap<>();

    static {
        dir.put("R", new int[]{0, 1});
        dir.put("L", new int[]{0, -1});
        dir.put("B", new int[]{-1, 0});
        dir.put("T", new int[]{1, 0});
        dir.put("RT", new int[]{1, 1});
        dir.put("LT", new int[]{1, -1});
        dir.put("RB", new int[]{-1, 1});
        dir.put("LB", new int[]{-1, -1});
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kx = king.charAt(1) - '1';
        int ky = king.charAt(0) - 'A';
        int sx = stone.charAt(1) - '1';
        int sy = stone.charAt(0) - 'A';

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int[] d = dir.get(move);

            int nkx = kx + d[0];
            int nky = ky + d[1];
            if (isOut(nkx, nky)) continue;

            if (sx == nkx && sy == nky) {
                int nsx = sx + d[0];
                int nsy = sy + d[1];

                if (isOut(nsx, nsy)) continue;

                sx = nsx;
                sy = nsy;
            }
            kx = nkx;
            ky = nky;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) (ky + 'A')).append((char) (kx + '1')).append("\n");
        sb.append((char) (sy + 'A')).append((char) (sx + '1'));
        System.out.println(sb);
    }

    public static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= 8 || y >= 8;
    }
}