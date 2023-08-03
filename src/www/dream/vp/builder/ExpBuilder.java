package www.dream.vp.builder;

import www.dream.vp.model.Element;

public class ExpBuilder {

	public static Element build(String exp) {
		//344+5*7777
		String[] eles = exp.split("\\+|\\*| "); // 뜻은 ("\\+|*") 는 +를  특수문자로 주지 마라.
		//tokenize 344, 5, 7777 (연산자, 피연산자 토크나이즈 해야됨. 공백도 해야됨) 토크나이즈 = 쪼개준다.
		for (String e : eles) {
			//7 이후 없어서 Out of Bounding. 그래서 2번만 돌린다. (344, 5, 7 3개니까)
			if (exp.length() == e.length())
				break;
			String op = exp.substring(e.length(), e.length() + 1);
			exp = exp.substring(e.length() + 1);
			System.out.println(op);
		}
		return null;
	}

}
