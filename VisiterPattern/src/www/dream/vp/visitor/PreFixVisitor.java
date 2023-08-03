package www.dream.vp.visitor;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;

/**
 * 나, 왼, 오, 순서로 계산해라. Concrete(말단, 최종) 비지터중 하나.
 */
public class PreFixVisitor extends Visitor {

	@Override
	public void visit(Composer composer) {
		super.recordHistory(composer.whoAreYou());
		composer.getLeft().accept(this);
		composer.getRight().accept(this);
	}

	@Override
	public void visit(Operand operand) {
		super.recordHistory(operand.whoAreYou());
	}

}
