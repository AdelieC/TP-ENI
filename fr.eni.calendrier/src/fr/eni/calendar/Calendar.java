package fr.eni.calendar;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Shows the calendar of the current month in the console by default.
 * You can choose another year and month if you follow the instructions at the bottom of the calendar.
 * @author adelie
 *
 */
public class Calendar {
	public final static Scanner SCAN = new Scanner(System.in);
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar(Locale.FRANCE);
		
		showCalendar(cal);
		while(askSomethingElse()) {
			cal = changeCalendar(cal);
			showCalendar(cal);
		}
		System.out.println("**************************************************");
		System.out.println("Vous avez choisi de quitter. Au revoir et à bientôt!");
		System.out.println("**************************************************");
	}

	
	/**
	 * Changes the year and month of the calendar with values given as input by the user.
	 * @param GregorianCalendar cal
	 * @return GregorianCalendar cal
	 */
	private static GregorianCalendar changeCalendar(GregorianCalendar cal) {
		String year = "", month = "";
		boolean valid = false;
		do {
				System.out.println("Entrez l'année que vous souhaitez voir :");
				year = SCAN.nextLine();
				valid = validateInt(year);
		} while(!valid);
		do {
				System.out.println("Entrez le numéro du mois que vous souhaitez voir :");
				month = SCAN.nextLine();
				valid = validateInt(month);
		} while(!valid);
		
		cal.set(GregorianCalendar.YEAR, Integer.parseInt(year));
		cal.set(GregorianCalendar.MONTH, Integer.parseInt(month)-1);
		return cal;
	}
	
	/**
	 * Checks if a String value can be converted into an int.
	 * Useful to check the validity of a supposed number given as input by a user.
	 * @param String number to convert into int
	 * @return boolean set to true if number is convertible to an int
	 */
	private static boolean validateInt(String num) {
		boolean valid = false;
		try {
			Integer.parseInt(num);
			valid = true;
		} catch(Exception e) {
			System.out.println();
			System.err.println("La valeur entrée est invalide. Entrez une valeur valide!");
			System.out.println();
		}
		return valid;
	}

	/**
	 * Prints a menu in the console to ask the user if he wants to do something else or to quit.
	 * @return boolean set to true if the user wants to do something else.
	 */
	private static boolean askSomethingElse() {
		boolean changeCal = false;
		System.out.println("Tapez 1 pour voir un autre mois, 2 pour quitter :");
		changeCal = SCAN.nextLine().equals("1");
		return changeCal;
	}
	
	/**
	 * Prints a little calendar in the console showing the month of the GregorianCalendar value given as param.
	 * @param GregorianCalendar cal
	 */
	private static void showCalendar(GregorianCalendar cal) {
		int day = 0, gap = 0, max = 0;
		
		//1) Reset date to first day of the month :
		cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
		
		//2) Print display
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
		System.out.println("L  M  M  J  V  S  D");
		
		//3) Print the gap at the beginning :
		day = cal.get(GregorianCalendar.DAY_OF_WEEK);
		gap = (day == 1) ? 6: day-2;
		for(int i = 0; i<gap; i++) System.out.print("   ");
		
		//4) Find number of days in current month :
		max = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		//5) Prints numbers and with all the returns in all the right places
		for(int i = 1; i<=max; i++) {
			if(i == 7-gap || (i+gap)%7 == 0) {
				System.out.println(i);
			} else {
				System.out.print(i + " ");
				if(i<=9)System.out.print(" ");
			}
		}
		System.out.println();
		System.out.println();
	}
}
