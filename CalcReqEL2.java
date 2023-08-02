package www.dream.bb.model;

import jakarta.servlet.http.HttpServletRequest;

/**
	 * Getter, Setter가 꼭 필요
	 */
public class CalcReqEL2 {
	private int operandFirst;
	private int operandSecond;
	private String operator;
	
	
	public int getOpFt() {
		return operandFirst;
	}



	public int getOperandSecond() {
		return operandSecond;
	}



	public String getOperator() {
		return operator;
	}



	public void setOperandFirst(int operandFirst) {
		this.operandFirst = operandFirst;
	}



	public void setOperandSecond(int operandSecond) {
		this.operandSecond = operandSecond;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int calc() {
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

	//Arr 배열
	public int[] getArr() {
		return new int[]{2, 5, 7};
	}
	public int calc2(HttpServletRequest request) {
		
		request.getParameter("operandFirst");
		return 0;
	}
	
	
}