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
		
	
		int i = 2;
		i = 1;
		
		
		double num22 =  Long.MAX_VALUE;
		System.out.println(num22);
		System.out.println(i);
		
		
		int vluAfter = 0 ;
		long vluBefore = 0 ;
		char cjrAfter = 'A' ;
		
		System.out.println("First reference : "+ vluAfter++); // 0 print 1 store 
		System.out.println("First reference : "+ --vluBefore);  // -1 print -1 store
		System.out.println("First reference : "+ cjrAfter++); // A print B store
		
		System.out.println("Second reference : "+ vluAfter);
		System.out.println("Second reference : "+ vluBefore);
		System.out.println(Integer.toBinaryString((~0b01<<2))+" Second reference : "+ cjrAfter);
	}
}
