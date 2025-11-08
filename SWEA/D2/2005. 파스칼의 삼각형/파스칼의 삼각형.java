import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testSize = 0; testSize < T; testSize++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];

			System.out.println("#" + (testSize + 1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					if (i == 0) {
						arr[i][0] = 1;
						break;
					} else if (i == 1) {
						arr[i][0] = 1;
						arr[i][1] = 1;
						break;
					}

					if (j == 0 || j == N - 1) {
						arr[i][j] = 1;
						continue;
					}

					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
			for (int[] row : arr) {
				for (int v : row) {
					if (v == 0)
						continue;
					System.out.print(v + " ");
				}
				System.out.println();
			}
		}
	}
}