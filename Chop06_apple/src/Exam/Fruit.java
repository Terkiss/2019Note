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
		System.out.println("���� �Ǹ����� ���� ��ȭ");
		seller.showSaleResult();
		System.out.println("���� �������� ���� ��ȭ");
		buyer.showBuyResult();
	}
}
