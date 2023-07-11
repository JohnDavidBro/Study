package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;

public class Board {
	/* 상수 정의 : private static final */
	private static final int ROOT = 3;
	private Cell[][] cells = new Cell[ROOT][ROOT];
	private List<Line> listLine = new ArrayList<>();

	/**
	 * 생성자, Countructor 생성시에 처리하여야 할 기능들을 작성하는 영역 칸과 줄을 만들고 둘 사이의 관계 정보까지 설정한다.
	 * (cardinality)
	 **/
	private Board() {
		// Cell 반복적 만들기.
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				cells[row][col] = new Cell();
			}
		}
		// 가로 Line 만들기 하는 곳
		for (int row = 0; row < ROOT; row++) {
			Line horizontalLine = new Line();
			for (int col = 0; col < ROOT; col++) {
				// Line아 Cell 받아라
				horizontalLine.getCellS(cells[row][col]);
			}
			listLine.add(horizontalLine);
		}
		// 세로 Line 만들기 하는 곳
		for (int col = 0; col < ROOT; col++) {
			Line verticalLine = new Line();
			for (int row = 0; row < ROOT; row++) {
				// Line아 Cell 받아라
				verticalLine.getCellS(cells[row][col]);
			}
			listLine.add(verticalLine);
		}
		// 정대각선(diagonal) 만들기 00, 11, 22
		Line diagonalLine = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			// Line아 Cell 받아라
			diagonalLine.getCellS(cells[idx][idx]);
		}
		listLine.add(diagonalLine);

		// 역대각선(rdiagonal) 만들기 00, 11, 22
		Line rDiagonalLine = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			// Line아 Cell 받아라
			rDiagonalLine.getCellS(cells[idx][ROOT - idx - 1]);
		}
		listLine.add(rDiagonalLine);
	}

	/**
	 * 상황출력
	 */
	private void display() {
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				System.out.print(cells[row][col].giveStonePrint());
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	public static void main(String[] args) {
		Board tttBoard = new Board();

		Player user = new Player(StoneType.White);
		Player user2 = new Player(StoneType.Black);

		boolean isUserTurn = false;
		do {
			if (isUserTurn) {
				user.favoriteSpot(tttBoard);
			} else {
				tttBoard.getEmptyCell(1, 1).setStone(StoneType.Black);
			}
			// 보드에 전부 저장되어 출력되다.
			tttBoard.display();

			// 유저 턴넘기기
			isUserTurn = !isUserTurn;
		} while (true);

	}

	public Cell getEmptyCell(int row, int col) {
		if (row < 0 || row >= ROOT)
		return null;
		if (col < 0 || col >= ROOT)
		return null;
		if (cells[row][col].emptyState())
			return cells[row][col];
		System.out.println("놓인 곳을 잘못 선택하셨습니다.");
		return null;
	}
}
