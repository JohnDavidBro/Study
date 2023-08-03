package www.dream.vp.model;

public class Plus extends Composer {
	public static final int priority = 2;
	private static final char displaychar = '+';

	public Plus(Element left, Element right) {
		super(left, right);
	}

	public String whoAreYou() {
		return Character.toString(displaychar);
	}
}
