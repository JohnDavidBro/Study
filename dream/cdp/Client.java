package www.dream.cdp;

import www.dream.cdp.Factory.AF;
import www.dream.cdp.FactoryPattern.AFFactory;
import www.dream.cdp.FactoryPattern.SPFactory;

public class Client {
	/** Factory Pattern들에 대한 실행 클라이언트 */
	public static void main(String[] args) {
		tacUseCase();
		AF am = AFFactory.createAF("M"); // "M"을 am 이라 부르고 그걸 실행해라.
		System.out.println(am.createSP().get().getEngineSound());
		System.out.println(am.createInsu().get().안심되니());
		AF af = AFFactory.createAF("F"); // "F"을 am 이라 부르고 그걸 실행해라.
		System.out.println(af.createSP().get().getEngineSound());
		System.out.println(af.createInsu().get().안심되니());
	}

	private static void tacUseCase() {
		System.out.println(SPFactory.createVehicle("House").get().getEngineSound());
		System.out.println(SPFactory.createVehicle("Car").get().getEngineSound());
	}

}
