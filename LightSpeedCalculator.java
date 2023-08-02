package a.b.c;

public class LightSpeedCalculator {
	/**
	 * 빛이 일년동안 가는 거리를 km단위로 산출하시오
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int 빛의속도 = 300000; // km/sec
		long 빛년거리 = 빛의속도 * 60L * 60 * 24 * 365; // overflow

		// 출력하기
		System.out.println("빛이 일\\년동안 간 거리는 \n" + 빛년거리 + "km입니다.");
	}
}
