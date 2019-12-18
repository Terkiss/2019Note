package Exam;

public class Fruit{

	FruitBuyer buyer;
	Fruitseller seller;

	public Fruit(int _money) 
	{
		buyer = new FruitBuyer(_money);
		seller = new Fruitseller();
	}
	public void run(int _appleCount)
	{
		buyer.buyApple(seller, _appleCount);
		System.out.println("과일 판매자의 현재 상화");
		seller.showSaleResult();
		System.out.println("과일 구매자의 현재 상화");
		buyer.showBuyResult();
	}
}
