package Exam;

public class tests {

	FruitBuyer buyer = new FruitBuyer(10000);
	Fruitseller seller = new Fruitseller();
	
	public tests() {}
	public void run(int _myMoney)
	{
		buyer.buyApple(seller, _myMoney);
		System.out.println("���� �Ǹ����� ���� ��ȭ");
		seller.showSaleResult();
		System.out.println("���� �������� ���� ��ȭ");
		buyer.showBuyResult();
	}
}
