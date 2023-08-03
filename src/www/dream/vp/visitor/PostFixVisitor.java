package www.dream.vp.visitor;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;

	/**
	 * 왼, 오, 나, 순서대로 계산해라. Concrete(말단, 최종) 비지터중 하나.
	 */
public class PostFixVisitor extends Visitor {

	@Override
	public void visit(Composer composer) {
		composer.getLeft().accept(this);
		composer.getRight().accept(this);
		super.recordHistory(composer.whoAreYou());
	}

	@Override
	public void visit(Operand operand) {
		super.recordHistory(operand.whoAreYou());
	}

}
