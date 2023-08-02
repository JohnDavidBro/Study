package www.dream.tdg.control;

import www.dream.tdg.model.Bullet;
import www.dream.tdg.model.Canon;
import www.dream.tdg.model.PhysicalEntity;
import www.dream.tdg.model.Planet;

public class GameController {

	public static void main(String[] args) {
		//좌 하단단 배치
		Canon myK9 = new Canon(0, 0);
		Bullet bullet = new Bullet();
		myK9.loadBullet(bullet);
		// 우 하단 배치 
		PhysicalEntity target = new PhysicalEntity(4100, 0);
		
		Planet.getInstance().load(myK9);
		Planet.getInstance().load(target);
		Planet.getInstance().load(bullet);

		myK9.setShootAngle(target);

		myK9.shoot();
		
		Planet.getInstance().startSimulation();
		
	}

}
