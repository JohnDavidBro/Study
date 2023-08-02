package www.dream.tdg.model;

import java.util.Scanner;

public class Canon extends PhysicalEntity {
	/** 5 ~ 85 */
	private static final int MIN_ANGLE = 5, MAX_ANGLE = 85;
	private double 발사각도;
	private Bullet bullet = null;

	public Canon(int i, int j) {
		super(i, j);
	}

	public void loadBullet(Bullet bullet) {
		clonePosition(bullet);
		this.bullet = bullet;
	}

	/** 
	 * 포수로 부터 각도 입력받기
	 */
	public void setShootAngle(PhysicalEntity target) {
		double distance = calcDistance(target);
		Scanner scan = new Scanner(System.in);
		int 발사각도;
		do {
			System.out.printf("적과의 거리는 %.2f미터입니다.\n포탄 속도는 %d미터입니다.\n발사각도를 입력하여 발사하세요", distance, bullet.get발사속도());
			System.out.printf("\n발사각도는 %d에서 %d사이로 입력하세요", MIN_ANGLE, MAX_ANGLE);
			발사각도 = scan.nextInt();
		} while (발사각도 < MIN_ANGLE  || 발사각도 > MAX_ANGLE);
		this.발사각도 = Math.toRadians(발사각도);
		bullet.setTarget(target);
	}

	public void shoot() {
		bullet.initVelocity(발사각도);
	}

}
