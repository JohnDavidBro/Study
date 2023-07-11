package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Cell> listCell = new ArrayList<>();
	
	public void getCellS(Cell cell) {
		listCell.add(cell);
		cell.getThisLine(this);
	}
	
	
}
