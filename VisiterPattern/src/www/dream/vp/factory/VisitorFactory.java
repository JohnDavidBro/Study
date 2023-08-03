package www.dream.vp.factory;

import www.dream.vp.visitor.InfixVisitor;
import www.dream.vp.visitor.PostFixVisitor;
import www.dream.vp.visitor.PreFixVisitor;
import www.dream.vp.visitor.Visitor;

/**
 * Visitor 팩토리 패턴 if문에 Null 포인트 방지를 위한 "InfixVisitor" 
 * type.equals(InfixVisitor)= Null 포인트 발생
 */
public class VisitorFactory {
	public static Visitor createVisitor(String type) {
		if ("InfixVisitor".equals(type)) //만약 InfixVisitor.equals(type)라면 new InfixVisitor값을 출력해라.
			return new InfixVisitor();
		if ("PreFixVisitor".equals(type)) //만약 PreFixVisitor.equals(type)라면 new PreFixVisitor값을 출력해라.
			return new PreFixVisitor();
		return new PostFixVisitor();
	}
}
