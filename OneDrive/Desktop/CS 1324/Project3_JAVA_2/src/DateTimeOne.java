import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;


public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private int seconds;
	
	HashMap<String, String> timeMap;
	HashMap<String, String> timeMap2;
	
	
	private LocalDateTime actualTime = LocalDateTime.now();

	public DateTimeOne() {

		timeMap = new HashMap<String, String>();
		timeMap2 = new HashMap<String, String>();
		
	}
	

	@Override
	int getValueOfSecond() {
		// TODO Auto-generated method stub
		return seconds;
	}

	@Override
	void dateTimeNow() {
		
		actualTime = LocalDateTime.now();
		DateTimeFormatter newDate = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm a");
		String currentTime = actualTime.format(newDate);
		System.out.println("The value of Second now: " + seconds);
		System.out.println("The Current Date/Time: " + currentTime);
		
	}

	@Override
	void dateTimeOfOtherCity() {
		System.out.println("Time at other zones:");
		System.out.println(String.format("Time on server: %02d:%02d" , actualTime.getHour() , actualTime.getMinute()));
		DateTimeFormatter otherCity = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(String.format("GMT: " + actualTime.atZone(ZoneId.of("Asia/Karachi")).format(DateTimeFormatter.ofPattern("h:mm")
				.withZone(ZoneOffset.UTC))));
		
		System.out.println(String.format("BST (90E): " + actualTime.atZone(ZoneId.of("Asia/Dhaka")).format(DateTimeFormatter.ofPattern("h:mm")
				.withZone(ZoneOffset.UTC))));
		
		System.out.println(String.format("CST (90W): %02d:%02d" , actualTime.getHour() , actualTime.getMinute())); 
	
	}

	@Override
	void dateTimeDifferentZone() {
		System.out.println("Date/time at other zones:");
		
		System.out.println(String.format("GMT: " + actualTime.atZone(ZoneId.of("Asia/Karachi")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
				.withZone(ZoneOffset.UTC))));
		
		System.out.println(String.format("BST: " + actualTime.atZone(ZoneId.of("Asia/Dhaka")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
				.withZone(ZoneOffset.UTC))));
		
		System.out.println(String.format("CST: %02d/%02d/%04d %02d:%02d", actualTime.getMonthValue(), actualTime.getDayOfMonth(), actualTime.getYear(),
				actualTime.getHour(), actualTime.getMinute()));
		
		String gMT = String.format(actualTime.atZone(ZoneId.of("Asia/Karachi")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
				.withZone(ZoneOffset.UTC)));
		
		String bST = String.format(actualTime.atZone(ZoneId.of("Asia/Dhaka")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
				.withZone(ZoneOffset.UTC)));
		
		String cST = String.format("%02d/%02d/%04d %02d:%02d", actualTime.getMonthValue(), actualTime.getDayOfMonth(), actualTime.getYear(),
				actualTime.getHour(), actualTime.getMinute());
		
		timeMap.put("GMT", gMT);
		timeMap.put("BST", bST);
		timeMap.put("CST", cST);

		
	}

	@Override
	void timeZoneHashMap() {
		timeMap.put("AST",  "10/01/2020 19:59");
		timeMap.put("ZST", "11/05/2018 19:59");
		
		timeMap2.put(timeMap.get("GMT"), "");
		timeMap2.put(timeMap.get("BST"), "");
		timeMap2.put(timeMap.get("CST"), "");
		timeMap2.put(timeMap.get("AST"), "");
		timeMap2.put(timeMap.get("ZST"), "");
		
		LocalDateTime [] temp = new LocalDateTime[timeMap.size()];
		
		DateTimeFormatter tempFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		LocalDateTime gMT2 = LocalDateTime.parse(timeMap.get("GMT"), tempFormatter);
		LocalDateTime bST2 = LocalDateTime.parse(timeMap.get("BST"), tempFormatter);
		LocalDateTime cST2 = LocalDateTime.parse(timeMap.get("CST"), tempFormatter);
		LocalDateTime aST2 = LocalDateTime.parse(timeMap.get("AST"), tempFormatter);
		LocalDateTime zST2 = LocalDateTime.parse(timeMap.get("ZST"), tempFormatter);
		
		temp[0] = gMT2;
		temp[1] = bST2;
		temp[2] = cST2;
		temp[3] = aST2;
		temp[4] = zST2;
		
		TreeMap<String, String> tree = new TreeMap<>(timeMap);
		
		System.out.println("Print Style 1:");
		
		for(String dateTime: tree.keySet()) {
			
			System.out.println(dateTime + " " + tree.get(dateTime));
			
		}
		
		TreeMap<String, String> tree2 = new TreeMap<>(timeMap2);
		
		System.out.println("Print Style 3:");
		
		for(String dateTime: tree2.keySet()) {
			
			System.out.println(dateTime + " " + tree2.get(dateTime));
		}
		
		System.out.println("Print Style 5: Final sorted Array:");
		
		for(int g = 0; g < temp.length; ++g) {
			
			System.out.println(temp[g]);
			
		}
		
	}

	@Override
	void sleepForFiveSec() {

		try {
			
			TimeUnit.SECONDS.sleep(5);
		}
		
		catch(InterruptedException x){
			
			x.printStackTrace();
		}// TODO Auto-generated method stub
		
	}
   
}