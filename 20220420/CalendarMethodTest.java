
public class CalendarMethodTest {

	public static void main(String[] args) {
		
		CalendarMethod calendarMethod = new CalendarMethod();
		
		System.out.println(calendarMethod.isLeapYear(2022));
		System.out.println(calendarMethod.lastDay(2022, 4));
		System.out.println(calendarMethod.totalDay(2022, 4, 20));
		System.out.println(calendarMethod.weekDay(2022, 4, 20));
		
		System.out.println(CalendarMethod.isLeapYear(2022));
		System.out.println(CalendarMethod.lastDay(2022, 4));
		System.out.println(CalendarMethod.totalDay(2022, 4, 20));
		System.out.println(CalendarMethod.weekDay(2022, 4, 20));
		
	}
	
}
