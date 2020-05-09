package Exam;

public class SelfCheck {
	int numOfBeed;
	public static int GameCount = 0;
	String name;
	public SelfCheck(String _name)
	{
		numOfBeed =0;
		name = _name;
		
	}
	public void setNumBeed(int _numOfBeed)
	{
		numOfBeed = _numOfBeed;
	}
	public void addBeed(int _numOfBeed) 
	{
		numOfBeed += _numOfBeed;
	}
	public int subBeed(int _numOfBeed) 
	{
		if( this.numOfBeed < _numOfBeed )
		{
			int result = this.numOfBeed;
			this.numOfBeed = 0;
			return -1;
		}
		numOfBeed -= _numOfBeed;
		return 0;
	}
	
	public int getNumBeed()
	{
		return numOfBeed;
	}
	
	public void printBeed()
	{
		System.out.println(name+"의 보유자산  -> 구슬  "+numOfBeed);
	}
	public void beedWar(SelfCheck _player, int _beedCount)
	{
		System.out.println(++GameCount+"차 게임에서 "+this.name+"은 "+_player.name+"의 구슬 "+_beedCount+"개를 획득햇다.");
		
		int subResult = _player.subBeed(_beedCount) ;
		
		if(subResult == 0)
		{
			this.addBeed(_beedCount);
		}
		else
		{
			this.addBeed(subResult);
		}
		
	}
	
}
