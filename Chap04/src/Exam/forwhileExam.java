package Exam;
import java.util.Scanner;
public class forwhileExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScaner = new Scanner(System.in);
		
		int num1, num2, num3, sum = 0 ;
		
		
		int i = 0;
		int dan =1;
		for(i = 2 ; dan <  10;   )
		{
			System.out.printf("%3d X %d = %2d ", i, dan, dan*i);
			i++;
			if(i == 10)
			{
				System.out.print("\n");
				//System.out.printf("----------------\n");
				i = 2;
				dan++;
			}
			
		}
		for(i = 1; i< 10; i++)
		{
			for(dan = 2; dan < 10 ; dan++  )
			{
				System.out.printf("%3d X %d = %2d ", dan, i, dan * i );
				
			}
			System.out.println(" *");
		}
		i = 1;
		while(i < 10)
		{
			dan = 2;
			while(dan < 10)
			{
				System.out.printf("%3d x %d = %2d ", dan, i, dan * i);
				dan++;
			}
			i++;
			System.out.printf("  == \n");
		}
	
		
		i = 1;
		dan = 2 ;
		while(true)
		{
			if(i == 10 )
			{
				break;
			}
			
			System.out.printf("%3d x %d = %2d ", dan, i, dan * i);
			dan++;
			if(dan == 10)
			{
				System.out.print("  --\n");
				dan = 2 ;
				i++;
			}
			
		}
		
		System.out.print("���۰�  �Է� : ");
		
		num1 = myScaner.nextInt();
		
		System.out.print("���� �Է� : " );
		
		num2 = myScaner.nextInt();
		
		System.out.print("������ �Է� : ");
		
		num3 = myScaner.nextInt();
		
		for( i= num1 ; i <= num2; i = i + num3 )
		{
			//sum = sum + i ;
			sum += i;
		}
		System.out.printf("%d ���� %d ���� %d�� ������ ���� �� :: %d \n", num1, num2, num3, sum);
		
		int Target = num1 + (-1*num3) + num2;
		System.out.print(Target);
		int index  = (int) 299 / 3;
		
		
		
	}

}
