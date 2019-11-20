package Exam;

import java.util.Scanner;

public class ThreeMulti {

	public static void main(String[] args) {
		
		Scanner myScaner = new Scanner(System.in);
		
		int num1, num2, ratio, sum = 0 ;
		int mok = 1;
		
		System.out.print("시작값  입력 : ");
		
		num1 = myScaner.nextInt();
		
		System.out.print("끝값 입력 : " );
		
		num2 = myScaner.nextInt();
		
		System.out.print("증가값 입력 : ");
		
		ratio = myScaner.nextInt();
		
		//개판 
		// TODO Auto-generated method stub
		for(int i = num1; i <= num2 ; i++)
		{
			int currentMok = i/ratio;
			
			if(currentMok == mok )
			{
				mok++;
				sum += i;
			}
			
			//if(i % 3 == 0 )
			//{
				//sum += i ;
			//}
		}
		System.out.println("1에서 100까지 3의 배수 합계 :: "+sum);
	}

}
