package Enumeration;

public class EnumMethod_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week today = Week.SUNDAY;
		
		String name = today.name();
		
		System.out.println(name);
		
		int ordinal = today.ordinal();
		
		System.out.println(ordinal);
	
		Week day1 = Week.MONDAY;
		Week day2 = Week.WENESDAY;
		int result = day1.compareTo(day2);
		
		int result2 = day2.compareTo(day1);
		
		System.out.println(result);

		System.out.println(result2);
		
		Week weekday = Week.valueOf("SUNDAY");
		
		if(weekday == Week.SATURDAY || weekday == Week.SUNDAY)
		{
			System.out.println("주말이군여");
		}
		
		Week[] days = Week.values();
		
		for(Week day : days)
		{
			System.out.print(day + " ");
		}
	}

}
