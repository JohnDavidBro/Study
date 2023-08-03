package study.util.scanner;

import java.util.Scanner;

public class AddTwo {

	public static void main(String[] args) {
		//두개의 정수를 Scanner통하여 입력 받는다.
		Scanner in = new Scanner(System.in);	//Scanner통하여
		
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int firstValue = in.nextInt();	//첫번째 정수를 입력 받는다
		
		System.out.print("두번째 숫자를 입력하세요 : ");
		int secondValue = in.nextInt();	//두번째 정수를 입력 받는다
		
		//이를 합하여 출력한다.
		int sum = firstValue + secondValue;
		System.out.println(sum);
	}

}
