package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private List<Line> listLine = new ArrayList<>();
	private StoneType depositedStone = StoneType.Empty; // 놓여진 돌
	
	public void getThisLine(Line line) {
		listLine.add(line);
		
	}

	public char giveStonePrint() {
		return depositedStone.gerDisplayChar();
	}

	public void setStone(StoneType myStone) {
		depositedStone = myStone;
		
	}

	public boolean emptyState() {
		return depositedStone == StoneType.Empty;
	}

}
