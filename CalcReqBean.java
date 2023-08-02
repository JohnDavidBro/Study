package www.dream.bb.model;

	/**
	 * Setter가 꼭 필요
	 */
public class CalcReqBean {
	private int operandFirst;
	private int operandSecond;
	private String operator;
	
	
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

}