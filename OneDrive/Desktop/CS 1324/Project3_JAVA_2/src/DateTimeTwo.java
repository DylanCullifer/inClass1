import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;

public class DateTimeTwo {

	private LocalDateTime actualTime = LocalDateTime.now();
	
	private int month = actualTime.getMonthValue();
	private int year = actualTime.getYear();
	
	HashMap<LocalDate, Integer> dateTimeMap = new HashMap<>();
	
	public DateTimeTwo() {
		
		
	}
	
	public void daysOfCurrentMonth() {
		int day10 = 10;
		int day18 = 18;
		
		String date = String.format("%d-%d-%d", year , month , day10);
		
		Date day = null;
		
		try {
			
			day = new SimpleDateFormat("yyyy-M-d").parse(date);
			
		}
		catch(ParseException x) {
			
			x.printStackTrace();
			
		}
		
		String date2 = String.format("%d-%d-%d", year, month, day18);
		
		Date day2 = null;
		
		try {
			
			day2 = new SimpleDateFormat("yyyy-M-d").parse(date2);
			
		}
		catch(ParseException x) {
			
			x.printStackTrace();
			
		}
		
		String tenthDayOfTheMonth = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(day);
		String eightteenthDayOfTheMonth = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(day2);
		
		System.out.println("The tenth day of this month is " + tenthDayOfTheMonth.toUpperCase() + " and eighteenth is "
				+ eightteenthDayOfTheMonth.toUpperCase());
		
	}
	
	public void daysOfAnyMonth() {
		
		
		
	}
	
	
	
	
	
}
