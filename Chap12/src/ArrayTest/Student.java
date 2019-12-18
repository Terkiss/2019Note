package ArrayTest;

import java.util.Scanner;
public class Student {
	
	boolean run = true;
	Scanner sc  = new Scanner(System.in);
	int selector, score;
	int[] student;
	public void run()
	{
		while(run)
		{
			initprint();
			printf("선택> ");
			selector = sc.nextInt();
			
			
			switch(selector)
			{
			case 1:
				printf("학생수> ");
				int stuNum = sc.nextInt();
				generateStudent(stuNum);
				break;
			case 2: 
				for(int i = 0 ; i < this.student.length; i++)
				{
					
					printf("scores[%d] : ", i);
					int score = sc.nextInt();
					this.student[i] = score;
				}
				break;
			case 3:
				
				for(int i = 0 ; i < this.student.length; i++)
				{
					printf("scores[%d] : %d \n", i, this.student[i]);
				}
				break;
			case 4:
				int temp = -1 ;
				float sum = 0;
				for(int i = 0 ; i < this.student.length; i++)
				{
					if(temp < this.student[i])
					{
						temp = this.student[i];
					}
					sum += this.student[i];
				}
				printf("최고 점수: %d \n", temp);
				printf("평균 점수 : %.1f \n", sum/this.student.length);
				
				break;
			case 5:
				run = false;
				printf("프로그램 종료");
				break;
			}
		}
	}
	
	private void initprint()
	{
		printf("------------------------------------------------------ \n");
		printf("1. 학생수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료  \n  ");
		printf("------------------------------------------------------ \n");
	}
	private void generateStudent(int num)
	{
		this.student = new int[num];
	}
	
	
	
	
	private void printf(String _message, Object ...a)
	{
		System.out.printf(_message, a);
	}
	private void printf(String _message)
	{
		System.out.printf(_message);
	}
	
}
