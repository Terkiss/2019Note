package Exam;

import java.util.Scanner;

public class FruitSalesMain{
	public static void main(String[] args) 
	{
		Self();
	}
	public static void Fruit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력 해주세요 :: ");
		Fruit fruit = new Fruit(sc.nextInt());
		
		
		while(true)
		{
			System.out.println("구입할 사과의 갯수 :: ");
			int _money =  sc.nextInt();
			fruit.run(_money);
		}
		
	}
	public static void Self()
	{
		SelfCheck sc = new SelfCheck("어린이1");
		SelfCheck sc2 = new SelfCheck("어린이2");
		
		
		sc.setNumBeed(15);
		sc2.setNumBeed(9);
		
		System.out.println("게임전 구슬의 보유 갯수");
		
		sc.printBeed();
		sc2.printBeed();
		
		sc.beedWar(sc2, 2);
		sc2.beedWar(sc, 7);
		
		System.out.println("게임후 구슬의 보유 갯수");
		
		sc.printBeed();
		sc2.printBeed();
		
	}
	
	

}
