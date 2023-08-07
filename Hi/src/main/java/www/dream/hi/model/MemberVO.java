package www.dream.hi.model;

public class MemberVO {
	private String id;
	private int bal;
	private String pwd;
	
	
	
	public MemberVO(String id, int bal, String pwd) {
		super();
		this.id = id;
		this.bal = bal;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public int getBal() {
		return bal;
	}
	public String getPwd() {
		return pwd;
	}

}
