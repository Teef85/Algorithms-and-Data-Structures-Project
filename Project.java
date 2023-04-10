import java.util.Scanner;
public class Project {

	public static int findMinCost(int[][] cost) {

		int M = cost.length;
		int N = cost.length;

		int[][] T = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				T[i][j] = cost[i][j];

				if (i == 0 && j > 0) {
					T[0][j] += T[0][j - 1];
				}

				else if (j == 0 && i > 0) {
					T[i][0] += T[i - 1][0];
				}

				if (i > 0 && j > 0) {
					T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
				}
			}
		}

		return T[M - 1][N - 1];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimensions of the board:");
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] cost = new int[r][c];
		System.out.println("Enter the values of the  Secures:\n");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		System.out.print("The minimum total cost is " + findMinCost(cost));
	}
}