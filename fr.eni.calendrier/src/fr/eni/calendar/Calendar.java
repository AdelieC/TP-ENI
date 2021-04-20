package fr.eni.calendar;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Calendar {

	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar(Locale.FRANCE);
		
		showCalendar(cal);
		while(askSomethingElse()) {
			cal = changeCalendar(cal);
			showCalendar(cal);
		}

	}

	
	private static GregorianCalendar changeCalendar(GregorianCalendar cal) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean askSomethingElse() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static void showCalendar(GregorianCalendar cal) {
		System.out.println("――――――――――――");
		System.out.println("CALENDRIER");
		System.out.println("――――――――――――");
		System.out.println();
		System.out.println(
				"*   " +
				cal.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG, Locale.FRANCE) +
				" " +
				cal.get(GregorianCalendar.YEAR) +
				"   *"
		);
		System.out.println(GregorianCalendar.);
		System.out.println("jour : " + cal.getDisplayName(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.SHORT, Locale.FRANCE));
	}


}
