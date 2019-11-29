package Exam;

public class MethodsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램의 시작 ");
		hiEvent(12, 175);
		hiEvent(13, 185);
		System.out.println("프로그램의 끝입니다");
		
		
	}
	
	public static void hiEvent(int age, double height)
	{
		print("좋은 아침 입니다. \n");
		print("제나이는"+age+"세 입니다\n");
		print("저의 키는 %5.2f \n", height);
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
