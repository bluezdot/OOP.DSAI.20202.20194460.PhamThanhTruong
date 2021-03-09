
import java.util.Scanner;

public class Lab01_6_4 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a month: ");
		String month = input.next();
		System.out.println("Enter a year: ");
		int year = input.nextInt();
		
		if (month.equals("Jan") || month.equals("January") || month.equals("1") || month.equals("Jan.")||
			month.equals("March") || month.equals("Mar.") || month.equals("Mar") || month.equals("3")||
			month.equals("May") || month.equals("5")||
			month.equals("July") || month.equals("Jul") || month.equals("7")||
			month.equals("August") || month.equals("Aug.") || month.equals("Aug") || month.equals("8")||
			month.equals("October") || month.equals("Oct.") || month.equals("Oct") || month.equals("10")||
			month.equals("December") || month.equals("Dec.") || month.equals("Dec") || month.equals("12")) {
				System.out.println("Number of days is: " + 31);
			}
		
		else if (month.equals("April") || month.equals("Apr.") || month.equals("Apr") || month.equals("4")||
				month.equals("June") || month.equals("Jun.") || month.equals("6") ||
				month.equals("September") || month.equals("Sep.") || month.equals("Sep") || month.equals("9")||
				month.equals("November") || month.equals("Nov.") || month.equals("Nove") || month.equals("11")) {
			    	System.out.println("Number of days is: " + 30);
		}
		
		else if (month.equals("February") || month.equals("Feb.") || month.equals("Feb") || month.equals("2")) {
			if (year % 4 == 0) {
				if (year %100 == 0) {
					if (year % 400 == 0) {
						System.out.println("Number of days is: " + 29);
					}
					else {
						System.out.println("Number of days is: " + 28);
					}
				}
				else {
					System.out.println("Number of days is: " + 29);
				}
			}
			else {
				System.out.println("Number of days is: " + 28);
			}
		}

	}
	
}