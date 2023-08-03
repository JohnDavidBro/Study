package www.dream.vp.test;

import www.dream.vp.factory.VisitorFactory;
import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;
import www.dream.vp.visitor.Visitor;

public class Main1 {

	public static void main(String[] args) {
		//3 + 5 * 7 ?
		Operand sam = new Operand(3);
		Operand oh = new Operand(5);
		Operand ch = new Operand(7);
		Composer multi = new Composer('*', oh, ch);
		Composer top = new Composer('+', sam, multi);
		
		Visitor previsitor = VisitorFactory.createVisitor("PreFixVisitor"); //PreFix 비지터를 만들다.
		// + 3 * 5 7
		top.accept(previsitor);
		System.out.println(previsitor.getHistory());

		Visitor infixvisitor = VisitorFactory.createVisitor("InfixVisitor"); //PreFix 비지터를 만들다.
		// 3 5 7 * +
		top.accept(infixvisitor);
		System.out.println(infixvisitor.getHistory());
		
		Visitor postvisitor = VisitorFactory.createVisitor("PostFixVisitor"); //PreFix 비지터를 만들다.
		// 3 + 5 * 7
		top.accept(postvisitor);
		System.out.println(postvisitor.getHistory());
		
	}

}
