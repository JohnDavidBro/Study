package light.year;

public class SpeedCalc {

	public static void main(String[] args) {
		lightYearToClosestStar();
		yearToClosestStarByYoyager();
	}

	private static void lightYearToClosestStar() {
		final int LIGHT_SPEED = 300000;	//빛의속도. 30만km/sec
		final float DISTANCE_TO_CLOSEST_STAR = 40e12f;	//가장 가까운 별까지의 거리. km
		final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;	//1년은 몇 초
		long lightDistancePerYear = (long) LIGHT_SPEED * SECONDS_PER_YEAR;	//km
		//광년을 산출해서 출력
		System.out.println(DISTANCE_TO_CLOSEST_STAR / lightDistancePerYear);
	}

	private static void yearToClosestStarByYoyager() {
		final int YOYAGER_SPEED = 60000;	//6만km/hour
		final float DISTANCE_TO_CLOSEST_STAR = 40e12f;	//가장 가까운 별까지의 거리. km
		final int HOURS_PER_YEAR = 24 * 365;	//1년은 몇 시간
		long voyagerDistancePerYear = (long) YOYAGER_SPEED * HOURS_PER_YEAR;	//km
		//광년을 산출해서 출력
		System.out.println(DISTANCE_TO_CLOSEST_STAR / voyagerDistancePerYear);
	}
}
