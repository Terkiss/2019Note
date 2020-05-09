package Enumeration;

import java.util.Calendar;

public class EmerWeek_Example {
	public static void main(String[] args)
	{
		Week today = null;
		
		Calendar cal = Calendar.getInstance();	
	
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week)
		{
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WENESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		
		
		System.out.println("오늘 요일 : "+today);
		
		if(today == Week.SUNDAY)
		{
			System.out.print("일요일에는 축구를 합니다.");
		}
		else if(today == Week.MONDAY)
		{
			System.out.print("열심히 자바 공부를 합니다.");
		}
	}
}
