package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
GregorianCalendar today = new GregorianCalendar();
GregorianCalendar expDate = new GregorianCalendar();

System.out.println(today.getTime());
System.out.println(today.get(Calendar.MONTH));
expDate.add(Calendar.MONTH, 6);
expDate.add(Calendar.YEAR, 3);
System.out.println(expDate.getTime());
	
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	System.out.println(formatter.format(expDate.getTime()));
	
	System.out.println(today.getTime());
	System.out.println(today.get(Calendar.DAY_OF_WEEK));
	}

}
