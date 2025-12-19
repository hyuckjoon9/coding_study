import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Coordinate[] coordinate = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinate[i] = new Coordinate();
            coordinate[i].x = Integer.parseInt(st.nextToken());
            coordinate[i].y = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate, (a, b) -> {
            if (a.y != b.y) return Integer.compare(a.y, b.y);
            return a.x - b.x;
        });

        StringBuilder sb = new StringBuilder();
        for (Coordinate c : coordinate) {
            sb.append(c.x).append(' ').append(c.y).append("\n");
        }
        System.out.println(sb);

    }
}

class Coordinate {
    int x;
    int y;
}