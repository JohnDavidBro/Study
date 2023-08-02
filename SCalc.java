package www.dream.bb.service;

import jakarta.servlet.http.HttpServletRequest;

public class SCalc {
	/** 답을 꺼내는 부분. */
	public static int calc(HttpServletRequest req) {
		int operandFirst = Integer.parseInt(req.getParameter("operandFirst"));
		String operator = req.getParameter("operator");
		int operandSecond = Integer.parseInt(req.getParameter("operandSecond"));
		
		/** 식을 계산하는 부분 */
		int ret = 0;
		switch (operator) {
		case "+" :
			ret = operandFirst + operandSecond;break;
		case "-" :
			ret = operandFirst - operandSecond;break;
		case "*" :
			ret = operandFirst * operandSecond;break;
		case "/" :
			ret = operandSecond == 0 ? Integer.MAX_VALUE : operandFirst / operandSecond;break;
		}
		return ret;
	}
}