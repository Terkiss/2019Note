package Exam;

public class MethodsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���α׷��� ���� ");
		hiEvent(12, 175);
		hiEvent(13, 185);
		System.out.println("���α׷��� ���Դϴ�");
		
		
	}
	
	public static void hiEvent(int age, double height)
	{
		print("���� ��ħ �Դϴ�. \n");
		print("�����̴�"+age+"�� �Դϴ�\n");
		print("���� Ű�� %5.2f \n", height);
	}
	
	
	
	
	
	
	
	
	public static void print(String a, Object...b )
	{
		System.out.printf(a,b);
	}
	public static void print(String a)
	{
		System.out.printf(a);
	}

}
