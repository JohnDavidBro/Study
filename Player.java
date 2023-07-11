package www.dream.ttt;

import java.util.Scanner;

public class Player {
	private StoneType myStone;

	private Scanner scan = new Scanner(System.in);

	public Player(StoneType myStone) {
		this.myStone = myStone;
	}

	public void favoriteSpot(Board tttBoard) {
		do {

			System.out.println("돌이 놓인 상황을 보고 빈칸을 선택하세요.");
			int row = scan.nextInt();
			int col = scan.nextInt();
			Cell chosenCell = tttBoard.getEmptyCell(row, col);
			if (chosenCell != null) { // 있으면, Null이 아니면.
				chosenCell.setStone(myStone);
				return;
			}
		} while (true);

	}
}
