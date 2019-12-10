package Exam;

public class Fruitseller {
	int numOfApple;
	int applePrice ;
	int myMoney ;
	public Fruitseller()
	{
		applePrice = 1000;
		numOfApple = 20;
		myMoney = 0 ;
	}
	public int saleApple(int _myMoney)
	{
		int appleCount = _myMoney/applePrice;
		this.numOfApple -= appleCount;
	
		return appleCount;
	}
	public void showSaleResult()
	{
		System.out.println("ÇöÀç ÀÜ¾× : "+this.myMoney);
		System.out.println("°úÀÏ °¹¼ö : "+this.numOfApple);
	}
}
