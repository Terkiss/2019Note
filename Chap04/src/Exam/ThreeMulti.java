package Exam;

import java.util.Scanner;

public class ThreeMulti {

	public static void main(String[] args) {
		
		Scanner myScaner = new Scanner(System.in);
		
		int num1, num2, ratio, sum = 0 ;
		int mok = 1;
		
		System.out.print("���۰�  �Է� : ");
		
		num1 = myScaner.nextInt();
		
		System.out.print("���� �Է� : " );
		
		num2 = myScaner.nextInt();
		
		System.out.print("������ �Է� : ");
		
		ratio = myScaner.nextInt();
		
		//���� 
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
		System.out.println("1���� 100���� 3�� ��� �հ� :: "+sum);
	}

}
