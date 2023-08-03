package study.util.scanner;

import java.util.Scanner;

public class BodyInfo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	//Scanner통하여
		
		System.out.println("나이, 이름, 체중....");
		int 나이 = in.nextInt();
		String 이름 = in.next();
		float 체중 = in.nextFloat();
		
		System.out.println("당신의 나이는 " + 나이 + "살입니다.");
		System.out.println("당신의 이름은 " + 이름 + "입니다.");
		System.out.println("당신의 체중은 " + 체중 + "kg입니다.");
	}

}
