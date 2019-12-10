package Exam;

public class tests {

	FruitBuyer buyer = new FruitBuyer(10000);
	Fruitseller seller = new Fruitseller();
	
	public tests() {}
	public void run(int _myMoney)
	{
		buyer.buyApple(seller, _myMoney);
		System.out.println("과일 판매자의 현재 상화");
		seller.showSaleResult();
		System.out.println("과일 구매자의 현재 상화");
		buyer.showBuyResult();
	}
}
