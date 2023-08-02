package www.dream.tdg.model;

public class PhysicalEntity {
	/** meter */
	private double positionX, positionY;

	public PhysicalEntity(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	protected void clonePosition(PhysicalEntity other) {
		other.positionX = this.positionX;
		other.positionY = this.positionY;
	}

	/**
	 * 유클리드 거리 계산
	 * @param other
	 * @return
	 */
	public double calcDistance(PhysicalEntity other) {
		return Math.sqrt((other.positionX - this.positionX) * (other.positionX - this.positionX)
				+ (other.positionY - this.positionY) * (other.positionY - this.positionY));
	}

	public void timeElapsed(float gravity, int timePeriod) {
		
	}

	protected void moveHorizontally(double horizontalSpeed, int timePeriod) {
		positionX += horizontalSpeed * timePeriod / 1000;
	}

	protected boolean moveVertically(double verticalSpeed, int timePeriod) {
		positionY += verticalSpeed * timePeriod / 1000;
		if (positionY < 0) {
			//포탄이 땅에 닿았군.
			Planet.getInstance().stopSimulation();
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("posX=%.2f, posY=%.2f", positionX, positionY);
	}

	
}
