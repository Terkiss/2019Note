package Exam;

public class FruitBuyer {
	int numOfApple;
	int myMoney ;
	
	public FruitBuyer(int _myMoney)
	{
		numOfApple = 0;
		myMoney = _myMoney;
	}
	public void buyApple(Fruitseller _seller, int _appCount)
	{
		
		if((_appCount * _seller.applePrice) < myMoney )
		{
			int applePrice = _seller.saleApple(_appCount);
			if(applePrice < 0)
			{
				return;
			}
			numOfApple += _appCount;
			myMoney -= applePrice;
		}
		else 
		{
			System.out.println("\n\n\n ÀÜ¾×ÀÌ ºÎÁ· ÇÕ´Ï´Ù");
			
		}
	}
	
	public void showBuyResult()
	{
		System.out.println("ÇöÀç ÀÜ¾× : "+myMoney);
		System.out.println("°úÀÏ °¹¼ö : "+numOfApple);
	}
}
