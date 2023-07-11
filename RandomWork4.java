package www.dream.work;

import java.util.Scanner;

public class RandomWork4 {

	public static void main(String[] args) {
		// 기본 값 입력. 보드 총 크기값 지정.
		Scanner scan = new Scanner(System.in);
		System.out.print("보드의 총 크기를 입력하시오: ");
		int ROOT = scan.nextInt();
		System.out.print("원하는 걸음 수를 적으세요: ");
		int TOT_STEPS = scan.nextInt();
		scan.close();
		boolean[][] visited = new boolean[ROOT][ROOT];
		
		// 중앙에서 시작할것.
		int curRow = ROOT / 2, curCol = ROOT / 2;
		visited[curRow][curCol] = true;
		
		int steps = 0;
		for (; steps < TOT_STEPS; steps++) {
			// 갈 방향 4종류로 임의 생성. North = 0, East = 1, South = 2, West = 3
			int direction = (int) (Math.random() * 4);
			switch (direction) {
			case 0:
				if (curRow > 0) {
					curRow--;
				}
			case 1:
				if (curCol < ROOT - 1) {
					curCol++;
				}
			case 2:
				if (curRow < ROOT - 1) {
					curRow++;
				}
			case 3:
				if (curCol > 0) {
					curCol--;
				}

			}
			visited[curRow][curCol] = true;
			displayBoard(ROOT, visited);
		}
	}

	/**
	 * 방문 경로 출력
	 * 
	 * @param visited
	 */
	private static void displayBoard(final int ROOT, boolean[][] visited) {
		for (boolean[] aRow : visited) {
			for (boolean v : aRow) {
				if (v) {
					System.out.print("# ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println("--".repeat(ROOT));
	}

}
