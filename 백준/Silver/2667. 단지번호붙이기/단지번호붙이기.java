import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> houses = new ArrayList<>();
        int villege = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    int house = bfs(i, j);
                    villege++;
                    houses.add(house);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(villege).append("\n");
        Collections.sort(houses);
        for (int v : houses) sb.append(v).append("\n");
        System.out.println(sb);

    }

    static public int bfs(int x, int y) {
        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(x, y));

        int count = 0;
        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();

            if (visited[cur.x][cur.y]) continue;

            visited[cur.x][cur.y] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
                if (board[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                dq.addLast(new Pair(nx, ny));
            }
        }
        return count;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}