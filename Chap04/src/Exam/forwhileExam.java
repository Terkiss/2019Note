package Exam;
import java.util.Scanner;
public class forwhileExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i = 0;
		int dan =2;
		for(i = 1 ; dan <  10; )
		{
			System.out.printf("%d X %d = %d \n", dan, i, dan*i);
			i++;
			if(i == 10)
			{
				System.out.printf("----------------\n");
				i = 1;
				dan++;
			}
			
		}
	}

}
