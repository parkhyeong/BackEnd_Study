package 제어문.반복문;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("test");
			System.out.print("종료? 0, 계속 1>> ");
			int choice = sc.nextInt();
			if (choice == 0) {
				System.out.println("종료합니다.");
				break;
				//System.exit(0); //프로그램 종 
			}
		}
		
		System.out.println("나는 실행이 될까요??");

	}

}
