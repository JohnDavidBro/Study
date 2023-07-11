package www.dream.ttt;

public enum StoneType {
	Empty('.'), White('o'), Black('x');
	private char displayChar;
	private StoneType(char displayChar) {
		this.displayChar = displayChar;
	}
		public char gerDisplayChar() {
			return displayChar;
		}
}
