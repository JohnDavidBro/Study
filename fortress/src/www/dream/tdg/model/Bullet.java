package www.dream.tdg.model;

public class Bullet extends PhysicalEntity {
	/** m/sec */
	private int 발사속도 = 333;
	//m/sec.수평 속도, 수직속도
	private double horizontalSpeed = 0.0, verticalSpeed = 0.0;
	
	private PhysicalEntity target;
	
	public Bullet() {
		super(-1, -1);
	}

	public int get발사속도() {
		return 발사속도;
	}

	public void initVelocity(double 발사각도) {
		horizontalSpeed = 발사속도 * Math.cos(발사각도);
		verticalSpeed = 발사속도 * Math.sin(발사각도);
	}

	@Override
	public void timeElapsed(float gravity, int timePeriod) {
		verticalSpeed += gravity * timePeriod / 1000;
		moveHorizontally(horizontalSpeed, timePeriod);
		boolean canMovenext = moveVertically(verticalSpeed, timePeriod);
		System.out.println(this);
		if (!canMovenext) {
			double distance = calcDistance(target);
			if (distance < 100)
				System.out.println("A학점");
			else if (distance < 500)
				System.out.println("B학점");
			else 
				System.out.println("F학점");
		}
	}

	public void setTarget(PhysicalEntity target) {
		this.target = target;
	}



}
