package JavaExamTest;

import java.util.Scanner;

public class Exercise {
	public static void main(String[] args)
	{
		// while ���� Scanner �̿��ؼ� Ű����κ��� �Էµ� �����ͷ� ���� ��� ��ȸ ����
		// ����� �����ϴ� �ڵ带 �ۼ�
		
		boolean run = true ;
		boolean inputError = false ;
		int selector = -1 ; 
		int balance = 0 ; 
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in) ;
		
		while(run)
		{
			
			// ���� ���α׷� 
			if(inputError == false)
			{
				System.out.println("-------------------------------------") ;
				System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����") ;
				System.out.println("-------------------------------------") ;
				
				System.out.print("����> ") ;
				selector = scanner.nextInt() ;
			}
			switch (selector) 
			{
				case 1: // ����
					{
						System.out.print("���ݾ�> ") ;
						
						int inputBalance = scanner.nextInt() ;
						if(inputBalance < 0)
						{
							System.out.println("�߸��� ���ݾ��� �Է� �ϼ˽��ϴ�") ;
							System.out.println("�ٽ� �Է��� �ּ���") ;
							inputError = true ;
						}
						else
						{
							balance += inputBalance ; 
							inputError = false ;
						}
					}
					break;
				case 2: // ���
					{
						System.out.print("��ݾ�> ") ;	
						int inputBalance = scanner.nextInt() ;
						if(inputBalance < 0)
						{
							System.out.println("�߸��� ��ݾ��� �Է� �ϼ˽��ϴ�") ;
							System.out.println("�ٽ� �Է��� �ּ���") ;
							inputError = true;
						}
						else
						{
							balance -= inputBalance ; 
							inputError = false;
						}
					}
					break;
				case 3: // �ܰ�
					System.out.println("�ܰ�> "+balance) ;
					break;
				case 4: // ����
					run = false ;
					break;
				default:
					System.out.println("1~4 �� �Է����ּ���") ;
			}
			
		}
		
		System.out.println("\n���α׷� ����");
	}

}
