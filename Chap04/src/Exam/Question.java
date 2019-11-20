package Exam;

public class Question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dice1, dice2 = 0 ;
		int eval = 0;
		int count =0;
		while(true)
		{
			if(count == 10)
			{
				break;
			}
			dice1 = (int) (Math.random()*6)+1;
			dice2 = (int) (Math.random()*6)+1;
			
			//System.out.printf("(%d, %d) \n", dice1, dice2);
			eval = 5 - dice1;
			if(dice2 == eval)
			{
				System.out.printf("(%d, %d) \n", dice1, dice2);
				count++;
			}
			
		}
		
		
		for(int i = 0 ; i < 5; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				System.out.printf("$");
			}
			System.out.printf("\n");
		}
	}

}
