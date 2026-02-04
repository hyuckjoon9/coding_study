/*
n(행),m(열) 입력
2차원 배열에 직사각형 입력 받음 - board
n과 m값 중 더 작은 값이 한 변의 최대길이 - side
인덱스 초과 처리 조건

우상단 인덱스 초과
if(j+side-1 >= m ) continue
좌하단 인덱스 초과
if(i+side-1 >= n) continue

좌상단 (i,j)
우상단 (i,j+side-1)
좌하단 (i+side-1, j)
우하단 (i+side-1, j+side-1)

위 네 값이 같으면 출력.
다르면 side-1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int maxLen = Math.min(n, m);

        for (int len = maxLen; len >= 1; len--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j + len - 1 >= m) continue;
                    if (i + len - 1 >= n) continue;

                    int a = board[i][j];
                    int b = board[i][j + len - 1];
                    int c = board[i + len - 1][j];
                    int d = board[i + len - 1][j + len - 1];

                    if (a == b && a == c && a == d) {
                        System.out.println(len * len);
                        return;
                    }
                }
            }
        }


    }
}