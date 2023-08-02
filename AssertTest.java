package www.dream.assertStudy;

import java.util.Scanner;

public class AssertTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("날짜를 입력하시오.");
		int date = input.nextInt();
		//날짜가 1이상이고 31이하인지를 검증한다.
		assert(date >= 1 && date <= 31);
		
		
	}

}
