package Exam;

import java.util.Scanner;

public class Exam {
	public static void main(String[] args)
	{
		
		
		Scanner scanner = new Scanner(System.in);

		int time ;
		int hour ;
		int min ;
		int sec ;
		
		System.out.print("## 계산할 초는 ? ::");
		time = scanner.nextInt();
		hour = time / (60 * 60) ;// 1시간  = 1분(60초) * 60 
		time = time % (60 * 60 ) ;
		min = time / 60 ;
		sec = time % 60 ;
		
		System.out.printf("\n 시간은 ==> %d 시간 \n", hour);
		System.out.printf(" 분은 ==> %d 몇분 \n", min);
		System.out.printf(" 초는 ==> %d 몇초 \n", sec);
		
		int money ;
		int fiveHundredWon;
		int hundredWon;
		int fiftyWon;
		int tenWon;
		int unnownMoney;
		System.out.print("## 교환할 돈은  ? ::");
		money = scanner.nextInt();
		fiveHundredWon = money / 500;
		money = money % 500 ;
		hundredWon = money / 100 ;
		money = money % 100;
		fiftyWon = money / 50;
		money = money %50 ;
		tenWon = money / 10 ;
		unnownMoney = money % 10;
		System.out.printf("\n 오백원짜리 ==> %d 개 \n", fiveHundredWon);
		System.out.printf(" 백원짜리 ==> %d 개 \n", hundredWon);
		System.out.printf(" 오십원짜리 ==> %d 개 \n", fiftyWon);
		System.out.printf(" 십원짜리 ==> %d 개 \n", tenWon);
		System.out.printf(" 바꾸지 못한 잔돈 ==> %d 원 \n", unnownMoney);
		
		
	}
}
