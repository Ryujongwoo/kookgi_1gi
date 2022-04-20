import java.util.Scanner;

public class MyCalendar {

//	윤년, 평년 판별 메소드
//	년도를 인수로 넘겨받아 윤년, 평년을 판단해서 윤년이면 true, 평년이면 false를 리턴하는 메소드
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
//	각 달의 마지막 날짜를 리턴하는 메소드
//	년, 월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
	public static int lastDay(int year, int month) {
		int[] m = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month - 1];
	}
	
//	년, 월, 일을 인수로 넘겨받아 1년 1월 1일 부터 지난 날짜를 계산해서 리턴하는 메소드
	public static int totalDay(int year, int month, int day) {
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		for (int i=1; i<month; i++) {
			sum += lastDay(year, i);
		}
		return sum += day;
	}
	
//	년, 월, 일을 인수로 넘겨받아 요일을 숫자로 리턴한다. 일(0), 월(1), 화(2), ..., 금(5), 토(6)
	public static int weekDay(int year, int month, int day) {
		return totalDay(year, month, day) % 7;
	}
	
//	static 메소드는 static 메소드만 실행할 수 있다.
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("달력을 출력할 년, 월을 입력하세요: ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		
		// boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		// System.out.println(result ? "윤년" : "평년");
		
		// 메소드를 호출할 때는 이름을 불러주면 된다.
		// 호출된 메소드가 실행이 완료되면 호출된 위치로 return 값을 가지고 돌아온다.
		System.out.println(isLeapYear(year) ? "윤년" : "평년");
		System.out.println(lastDay(year, month));
		System.out.println(totalDay(year, month, 1));
		System.out.println(weekDay(year, month, 1));
	}
	
}



















