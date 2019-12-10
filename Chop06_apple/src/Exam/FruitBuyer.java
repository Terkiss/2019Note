package Exam;

public class FruitBuyer {
	int numOfApple;
	int myMoney ;
	
	public FruitBuyer(int _myMoney)
	{
		this.numOfApple = 0;
		this.myMoney = _myMoney;
	}
	public void buyApple(Fruitseller _seller, int _money)
	{
		
		
		int appleCount = _seller.saleApple(_money);
		numOfApple += appleCount;
		myMoney -= _seller.applePrice * appleCount;
	}
	
	public void showBuyResult()
	{
		System.out.println("ÇöÀç ÀÜ¾× : "+this.myMoney);
		System.out.println("°úÀÏ °¹¼ö : "+this.numOfApple);
	}
}
