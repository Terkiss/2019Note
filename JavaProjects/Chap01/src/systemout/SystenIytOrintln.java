package systemout;



public class SystenIytOrintln {
	static int a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(7);
		System.out.println(3.15);
		System.out.println("3+5 ="+8);
		System.out.println(3.15 + " 는 실수 입니다");
		System.out.println("3+5"+"의 연산 결과는 8입니다.");
		System.out.println(3+5);	
	    
		int num1 = 10 ;
		int num2 = 20 ;
		
		int num3 = num1 + num2 ;
		
		System.out.println(num1 + "+" + num2 + "=" + num3) ;
		
		int decimal = 12;
		int hexdecimal = 0xC;
		int octet = 014;
		int binary = 0b1100;
		
		System.out.println(decimal);
		System.out.println(hexdecimal);
		System.out.println(octet);
		System.out.println(binary);
		
		char firsrchar =  'A' ;
		char firstchar2 = '\u0041' ;
		char ch = 'a' ;
		char ch2 = '한' ;
		
		System.out.println(firsrchar +" "+ firstchar2  + " " + ch +" "+ ch2 ) ;
		
	}
}
