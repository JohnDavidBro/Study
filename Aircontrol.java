package www.dream.aircon;

public class Aircontrol {

	public static void main(String[] args) {
		//방의 현재 온도
		float curTemp = 30;
		//설정 온도
		float targetTemp = 23;
		//여유 범위
		final int BOUNDARY = 2; // 18~22
		//에어컨 작동상태
		boolean isOn = false, prevACStatus = isOn;
		
		for (;true;) {
			//최종본
			//꺼져있을 시 더우면 에어컨키기, 켜져있을 때 너무 추우면 에어컨끈다.
			isOn = curTemp > targetTemp + BOUNDARY || (isOn && curTemp >= targetTemp - BOUNDARY);
			
			curTemp += isOn ? -1 : 1;
			
			if (prevACStatus != isOn) {
				System.out.printf("에어컨 상태 %b, 현재온도 : %f\n", isOn, curTemp);
			}
			prevACStatus = isOn;
			try {
				Thread.sleep(200); // 초당 5번 계산
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
