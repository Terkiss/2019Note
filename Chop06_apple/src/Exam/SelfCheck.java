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
		System.out.println(name+"�� �����ڻ�  -> ����  "+numOfBeed);
	}
	public void beedWar(SelfCheck _player, int _beedCount)
	{
		System.out.println(++GameCount+"�� ���ӿ��� "+this.name+"�� "+_player.name+"�� ���� "+_beedCount+"���� ȹ���޴�.");
		
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
