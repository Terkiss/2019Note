package Exam;

public class Fruitseller {
	int numOfApple;
	final int applePrice ;
	int myMoney ;
	public Fruitseller()
	{
		
		applePrice = (int) (Math.random() * 2000);
		System.out.println("판매 단가 설정 "+applePrice );
		numOfApple =  (int)(Math.random() * 200);
		myMoney = 0 ;
	}
	public int saleApple(int _appleCount)
	{
		if(_appleCount <= numOfApple)
		{
			int ApplesalePrice = _appleCount * applePrice;
			numOfApple -= _appleCount;
			myMoney += ApplesalePrice;
			return ApplesalePrice;
		}
		else
		{
			System.out.println("다음 수확을 기달리세요");
			return -1;
		}
		
	}
	public void showSaleResult()
	{
		System.out.println("현재 잔액 : "+myMoney);
		System.out.println("과일 갯수 : "+numOfApple);
	}
}
