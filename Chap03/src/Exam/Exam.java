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
		
		System.out.print("## ����� �ʴ� ? ::");
		time = scanner.nextInt();
		hour = time / (60 * 60) ;// 1�ð�  = 1��(60��) * 60 
		time = time % (60 * 60 ) ;
		min = time / 60 ;
		sec = time % 60 ;
		
		System.out.printf("\n �ð��� ==> %d �ð� \n", hour);
		System.out.printf(" ���� ==> %d ��� \n", min);
		System.out.printf(" �ʴ� ==> %d ���� \n", sec);
		
		int money ;
		int fiveHundredWon;
		int hundredWon;
		int fiftyWon;
		int tenWon;
		int unnownMoney;
		System.out.print("## ��ȯ�� ����  ? ::");
		money = scanner.nextInt();
		fiveHundredWon = money / 500;
		money = money % 500 ;
		hundredWon = money / 100 ;
		money = money % 100;
		fiftyWon = money / 50;
		money = money %50 ;
		tenWon = money / 10 ;
		unnownMoney = money % 10;
		System.out.printf("\n �����¥�� ==> %d �� \n", fiveHundredWon);
		System.out.printf(" ���¥�� ==> %d �� \n", hundredWon);
		System.out.printf(" ���ʿ�¥�� ==> %d �� \n", fiftyWon);
		System.out.printf(" �ʿ�¥�� ==> %d �� \n", tenWon);
		System.out.printf(" �ٲ��� ���� �ܵ� ==> %d �� \n", unnownMoney);
		
		
	}
}
