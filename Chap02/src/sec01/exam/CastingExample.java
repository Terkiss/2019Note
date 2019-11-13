package sec01.exam;

public class CastingExample {
	public static void main(String[] args)
	{
		int intValue = 44032 ;
		char intValue2  = (char) intValue;
		
		System.out.println(intValue2);

		long longValue = 500 ;
		
		int intValue21 = (int) longValue ;
		
		System.out.println(intValue21 );
		
		double doubleValue = 3.14 ; 
		intValue = (int) doubleValue;
		
		
		
		System.out.println(intValue);
	}
}
