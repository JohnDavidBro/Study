package www.dream.vp.model;

import www.dream.vp.visitor.Visitor;

/**
 * Element 를 상속한다.
 */
public class Composer extends Element {
	private char displaychar;
	private Element left, right; // Link 를 표현

	public Composer(char displaychar, Element left, Element right) {
		this.displaychar = displaychar;
		this.left = left;
		this.right = right;
	}

	public String whoAreYou() {
		return Character.toString(displaychar);
	}

	public Element getLeft() {
		return left;
	}

	public Element getRight() {
		return right;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
