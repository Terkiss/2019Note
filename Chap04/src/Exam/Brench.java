package Exam;

import java.util.Scanner;

public class Brench {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * int a = 200; if (a < 100) { System.out.print("100 ���� �۱��� \n");
		 * System.out.print("���̸� �� ���嵵 ���̰���???\n"); } else {
		 * System.out.printf("100���� ũ����\n"); System.out.printf("�����̸� �� ���嵵 ���̰���\n");
		 * 
		 * } System.out.printf("���α׷� ��! \n");
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
		 * Object a1 =(a < b) ? (System.out.printf("a�� b���� �۱���?")) :
		 * (System.out.printf("b�� a���� �۱���?"));
		 */
		
		int leftOperator = 0;
		int rightOperator = 0;
		
		int result1 = 0;
		double result2 = 0;
		
		char op ;
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.printf("ù�� �� �� �Է�  : ");
		
		leftOperator = myScanner.nextInt();
		
		System.out.printf("����� �����ڸ� �Է��ϼ��� : ");
		
		op = myScanner.next().charAt(0);
		
		System.out.printf("�ι��� ���� �Է��ϼ��� : ");
		
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
			System.out.printf("�����ڸ� �߸� �Է� �ϼ˽��ϴ�");
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
