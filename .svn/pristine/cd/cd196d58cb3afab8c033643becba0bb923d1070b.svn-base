package Exam;

import java.util.Scanner;

public class LoopCal {
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		
		int leftOp;
		int rightOp;
		String middleOp;
		
		while(true)
		{
			
			System.out.printf("첫번 쨰 수 입력  : ");
			
			leftOp = myScanner.nextInt();
			
			middleOp = myScanner.nextLine();
			System.out.printf("계산할 연산자를 입력하세요 : ");
			
			middleOp = myScanner.nextLine();
			
			System.out.printf("두번쨰 수를 입력하세요 : ");
			
			rightOp = myScanner.nextInt();
			
			
			switch(middleOp)
			{
				case "+":
					System.out.println(leftOp +" "+middleOp+" "+rightOp+"  =  "+ (leftOp+rightOp) );
					break;
				case "-":
					System.out.println(leftOp +" "+middleOp+" "+rightOp+"  =  "+ (leftOp-rightOp) );
					break;
				case "*":
					System.out.println(leftOp +" "+middleOp+" "+rightOp+"  =  "+ (leftOp*rightOp) );
					break;
				case "/":
					System.out.println(leftOp +" "+middleOp+" "+rightOp+"  =  "+ (leftOp/rightOp) );
					break;
				case "%":
					System.out.println(leftOp +" "+middleOp+" "+rightOp+"  =  "+ (leftOp%rightOp) );
					break;
				default:
					System.out.printf("연산자를 잘못 입력 하셧습니다 \n");
			}
		}
		
	}
}
