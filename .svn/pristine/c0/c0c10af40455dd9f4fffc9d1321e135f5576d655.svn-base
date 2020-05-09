package JavaExamTest;

import java.util.Scanner;

public class Exercise {
	public static void main(String[] args)
	{
		// while 문과 Scanner 이용해서 키보드로부터 입력된 데이터로 예금 출금 조회 종료
		// 기능을 제공하는 코드를 작성
		
		boolean run = true ;
		boolean inputError = false ;
		int selector = -1 ; 
		int balance = 0 ; 
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in) ;
		
		while(run)
		{
			
			// 은행 프로그램 
			if(inputError == false)
			{
				System.out.println("-------------------------------------") ;
				System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료") ;
				System.out.println("-------------------------------------") ;
				
				System.out.print("선택> ") ;
				selector = scanner.nextInt() ;
			}
			switch (selector) 
			{
				case 1: // 예금
					{
						System.out.print("예금액> ") ;
						
						int inputBalance = scanner.nextInt() ;
						if(inputBalance < 0)
						{
							System.out.println("잘못된 예금액을 입력 하셧습니다") ;
							System.out.println("다시 입력해 주세요") ;
							inputError = true ;
						}
						else
						{
							balance += inputBalance ; 
							inputError = false ;
						}
					}
					break;
				case 2: // 출금
					{
						System.out.print("출금액> ") ;	
						int inputBalance = scanner.nextInt() ;
						if(inputBalance < 0)
						{
							System.out.println("잘못된 출금액을 입력 하셧습니다") ;
							System.out.println("다시 입력해 주세요") ;
							inputError = true;
						}
						else
						{
							balance -= inputBalance ; 
							inputError = false;
						}
					}
					break;
				case 3: // 잔고
					System.out.println("잔고> "+balance) ;
					break;
				case 4: // 종료
					run = false ;
					break;
				default:
					System.out.println("1~4 만 입력해주세요") ;
			}
			
		}
		
		System.out.println("\n프로그램 종료");
	}

}
