package exam;
import java.util.Scanner;

public class Program {
	
	
	
	public static void main(String args[])
	{
		/*
		int mathMetic = 0, english = 0, korean = 0;
		Scanner sc = new Scanner(System.in);
		print("���� ������ �Է� ���ּ��� : ");
		korean = sc.nextInt();
		print("���� ������ �Է� ���ּ��� : ");
		mathMetic = sc.nextInt();
		
		print("���� ������ �Է� ���ּ��� : ");
		english = sc.nextInt();
		
		if(evalution(korean, mathMetic, english)&& (evalution(korean)&&evalution(english)&&evalution(mathMetic) ) )
		{
			print("�հ� �Դϴ�");
		}
		else
		{
			print("�� �� �� �Դϴ�");
		}
		
		*/

		/*
		String selector  ; 
		Scanner sc = new Scanner(System.in);
		int dan =9;
		print("���� �Ͻʼ� ���� : ����,for,f \nȭ�Ϲ�: ȭ��,while,w");
		selector = sc.next();
		if(selector.equals("����")  ||selector.equals("for")||selector.equals("f"))
		print("��� �ϰ� ���� ���� �Է� �ϼ��� ");
		dan = sc.nextInt();
		print("���� \n");
		forMethodsGugudan(dan);
		print("���Ϲ� \n");
		whileMethodsGugudan(dan);
		*/
		
		
	}
	public static void forMethodsGugudan(int dan)
	{
		for(int i = 1; i < 10; i++)
		{
			print("%d x %d = %d \n", dan, i, dan*i);
		}
	}
	public static void whileMethodsGugudan(int dan)
	{
		int i = 1;
		while(i < 10)
		{
			print("%d x %d = %d \n", dan, i, dan*i);
			i++;
		}
	}
	public static void print(String s, Object... a )
	{
		System.out.printf(s, a);
	}
	public static boolean evalution(int point)
	{
		if(point >= 40)
		{
	
			return true;
		}
		print("���� �Դϴ� ");
		return false;
	}
	public static boolean evalution(int point, int point2, int point3)
	{
		if((point+ point2 + point3) >= 180)
		{
			return true;
		}
		return false;
	}

}

