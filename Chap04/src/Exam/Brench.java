package Exam;

import java.util.Scanner;

public class Brench {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * int a = 200; if (a < 100) { System.out.print("100 보다 작군요 \n");
		 * System.out.print("참이면 이 문장도 보이겟죠???\n"); } else {
		 * System.out.printf("100보다 크군요\n"); System.out.printf("거짓이면 이 문장도 보이겟죠\n");
		 * 
		 * } System.out.printf("프로그램 끝! \n");
		 * 
		 * String statement1 = "true1"; String statement2 = "true2"; String statement3 =
		 * "true3"; String statement4 = "true4";
		 * 
		 * boolean booleanExpress = true; boolean booleanExpress2 = false;
		 * 
		 * if(booleanExpress) { System.out.printf(statement1); } else
		 * if(booleanExpress2) { System.out.printf(statement2); }
		 * 
		 * int b = 210;
		 * 
		 * Object a1 =(a < b) ? (System.out.printf("a가 b보다 작구나?")) :
		 * (System.out.printf("b가 a보다 작구나?"));
		 */
		
		int leftOperator = 0;
		int rightOperator = 0;
		
		int result1 = 0;
		double result2 = 0;
		
		char op ;
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.printf("첫번 쨰 수 입력  : ");
		
		leftOperator = myScanner.nextInt();
		
		System.out.printf("계산할 연산자를 입력하세요 : ");
		
		op = myScanner.next().charAt(0);
		
		System.out.printf("두번쨰 수를 입력하세요 : ");
		
		rightOperator = myScanner.nextInt();
		
		
		if(op == '+')
		{
			System.out.println(leftOperator +" "+op+" "+rightOperator+"  =  "+ (leftOperator+rightOperator) );
		}
		else if(op == '-')
		{
			System.out.println(leftOperator +" "+op+" "+rightOperator+"  =  "+ (leftOperator-rightOperator) );
		}
		else if(op == '*')
		{
			System.out.println(leftOperator +" "+op+" "+rightOperator+"  =  "+ (leftOperator*rightOperator) );
		}
		else if(op == '/')
		{
			System.out.println(leftOperator +" "+op+" "+rightOperator+"  =  "+ (leftOperator/rightOperator) );
		}
		else if(op == '%')
		{
			System.out.println(leftOperator +" "+op+" "+rightOperator+"  =  "+ (leftOperator%rightOperator) );
		}
		else
		{
			System.out.printf("연산자를 잘못 입력 하셧습니다");
		}	
		
		
		switch(op)
		{
			case '+':
				break;
			case '-':
				break;
			case '*':
				break;
			case '/':
				break;
			case '%':
				break;
			default:
				break;
		}
	}

}
