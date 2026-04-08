import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        int startI = 0, startJ = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    startI = i;
                    startJ = j;
                } else if (num == 0) {
                    dist[i][j] = 0;
                }
                board[i][j] = num;

            }
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(startI, startJ));
        dist[startI][startJ] = 0;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();


            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0) {
                    continue;
                }
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                dq.addLast(new Node(nx, ny));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}