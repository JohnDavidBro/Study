package www.dream.vp.model;

import www.dream.vp.visitor.Visitor;
	/**
	 * 노드 볼텍스
	 * Visitor역할이 방문할 곳을 나타내는 역할
	 * 방문자를 받아들이는 accept메소드를 선언한다.
	 */
public abstract class Element {
	    public abstract void accept(Visitor visitor);
	    public abstract String whoAreYou();
	}
