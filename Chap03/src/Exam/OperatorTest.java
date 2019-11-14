package Exam;

import java.util.Scanner;

public class OperatorTest {
	public static void main(String[] args)
	{
		// 기본 연산자
		System.out.println("-----------------\n 기본 연산자 테스트") ;
		System.out.println("정수형 나눗셈" + 7/3) ;
		System.out.println("실수"+ 7.0f/3.0f) ;
		System.out.println("형변한"+ (float)7/3) ;
		System.out.println("");
		
	
		// 복합 대입 연산자.
		System.out.println("-----------------\n 복합 대입 연산자 테스트") ;
		double e= 3.1;
		e+=2.1;
		e*=2;
		int n = 5;
		n*=2.2;
		
		System.out.println(e) ;
		System.out.println(n) ;
		
		
		
		// 비교 연산자의 예 
		
		System.out.println("-----------------\n 비교 연산자 테스트") ;
		int A = 10 ;
		int B = 20 ;
		if(true )
		{
			System.out.println("참") ;
		}
		else 
		{
			System.out.println("거짓 ") ;
		}
		
		if( A > B )
		{
			System.out.println("A가 크다 ") ;
		}
		else 
		{
			System.out.println("B가 크다 ") ;
		}
		
		if( A != B )
		{
			System.out.println("A 와 B는 다르당") ;
		}
		else
		{
			System.out.println("A 와 B는 같다") ;
		}
		
		
		// 논리 연산자
		System.out.println("-----------------\n True / False 판단을 위한 논리 연산자 테스트") ;
		
		int num1 = 10 ;
		int num2 = 20 ;
		
		boolean result1 =  (num1 == 10 ) && (num2 == 20) ;
		boolean result2 = (num1 <= 12) && (num2 >= 30);
		
		System.out.println(" num = 10 그리고 num2 = 20 : " + result1);
		System.out.println(" num <= 12 또느ㅜㄴ num2 >= 30 : " + result2);
		
		if( !(num1 == num2) )
		{
			System.out.println("num1 과 num2는 같지않다.");
		}
		else
		{
			System.out.println("num1 과 num2는 같다");
		}
		
		
		// 간결한 코드 작서응ㄹ 위한 단항 연산자 .;;; 
		System.out.println("-----------------\n 간결한 코드 작서응ㄹ 우이한 단항 연산자  연산자 테스트") ;
		
		
		int vluAfter = 0 ;
		long vluBefore = 0 ;
		char cjrAfter = 'A' ;
		
		System.out.println("First reference : "+ vluAfter++); // 0 print 1 store 
		System.out.println("First reference : "+ --vluBefore);  // -1 print -1 store
		System.out.println("First reference : "+ cjrAfter++); // A print B store
		
		System.out.println("Second reference : "+ vluAfter);
		System.out.println("Second reference : "+ vluBefore);
		System.out.println(" Second reference : "+ cjrAfter);
		
		
		
		// 비트 연산자
		System.out.println("-----------------\n 비트 연산자 테스트") ;
		
		int ShiftNum1 = 5 ; // 00000000 00000000 000000000 00000101
		int ShiftNum2 = 3 ; // 00000000 00000000 000000000 00000011
		int ShiftNum3 = -1 ; // 1111111 11111111 11111111 11111111
		
		System.out.println(ShiftNum1 & ShiftNum2) ; // 00000000 00000000 00000000 00000001 = 1
		System.out.println(ShiftNum1 | ShiftNum2) ; // 00000000 00000000 00000000 00000111 = 7
		System.out.println(ShiftNum1 ^ ShiftNum2) ; // 00000000	00000000 00000000 00000110 = 6
		System.out.println(~ShiftNum3); // 00000000	00000000 00000000 00000000 = 0 
		
		// 시프트 연산자
		System.out.println("-----------------\n 시프트 연산자 테스트") ;
		
		System.out.println( 2 << 1 ) ; // 00000010 - > 000000100 = 4
		System.out.println( 2 << 2 ) ; // 00000010 - >2 00001000 = 8
		System.out.println( 2 << 3 ) ; // 00000010 - >3 00010000 = 16
		System.out.println( 8 >> 1 ) ; // 00001000 - > 000100000 = 16
		System.out.println( 8 >> 2 ) ; // 00010000 - >2 00100000 = 32
		System.out.println( 8 >> 3 ) ; // 00100000 - >3 01000000 = 64
		// 00001000 -> 2Complete -> 11111000 
		System.out.println( -8 >> 1 ) ; // 11111000 - > 11111100 = -4
		System.out.println( -8 >> 2 ) ; // 11111000 - >2 11111110 = -2
		System.out.println( -8 >> 3 ) ; // 11111000 - >3 11111111 = -1
		System.out.println( -8 >>> 1 ) ; //11111000 - >>1 01111100
		// 11111111 11111111 11111111 11111000
		// 01111111 11111111 11111111 11111100
		int view  =  0b01111111111111111111111111111100;
		System.out.println(view+"\ndd"+Integer.toBinaryString( -8 ) );
		System.out.println("dd"+Integer.toBinaryString( -8 >>> -1) );
		// String  테스트
		System.out.println("-----------------\n String calss 테스트") ;
		String StringVar1 = "A" ;
		String StringVar2 = "홍길동" ;
		
		String StringNum = "30000";
		int Value = Integer.parseInt(StringNum);
		System.out.println(Value+30);
		System.out.printf("테스트 %x ", 3 );
		
		
		//  표준 입 출력 테스트
		System.out.println("-----------------\n 표준 입출력 테스트") ;
		System.out.println("## 계산할 초는 ? ::");
		
		Scanner scanner = new Scanner(System.in);
		
		String inData;
		int time ;
		int hour ;
		int min ;
		int sec ;
		
		
		
	}
}
