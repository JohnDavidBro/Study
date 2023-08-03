package www.dream.vp.model;

import www.dream.vp.visitor.Visitor;

/**
 * Element 를 상속한다.
 */
public abstract class Composer extends Element {
	private Element left, right; // Link 를 표현

	public Composer(Element left, Element right) {
		this.left = left;
		this.right = right;
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
