package edu.cs61b.hw2;

/* Date.java */

class Date {

	/* Private data fields */
	private int month;
	private int day;
	private int year;

	/*
	 * Get functions for private data fields.
	 */
	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public int getYear() {
		return this.year;
	}

	/**
	 * Constructs a date with the given month, day and year. If the date is not
	 * valid, the entire program will halt with an error message.
	 * 
	 * @param month
	 *            is a month, numbered in the range 1...12.
	 * @param day
	 *            is between 1 and the number of days in the given month.
	 * @param year
	 *            is the year in question, with no digits omitted.
	 */
	public Date(int month, int day, int year) {
		if (isValidDate(month, day, year)) {
			this.month = month;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Invalid date");
			System.exit(0);
		}
	}

	/**
	 * Constructs a Date object corresponding to the given string.
	 * 
	 * @param s
	 *            should be a string of the form "month/day/year" where month
	 *            must be one or two digits, day must be one or two digits, and
	 *            year must be between 1 and 4 digits. If s does not match these
	 *            requirements or is not a valid date, the program halts with an
	 *            error message.
	 */
	public Date(String s) {
		String[] dateParts = s.split("/");

		if (dateParts.length == 3) {
			int month = Integer.parseInt(dateParts[0]);
			int day = Integer.parseInt(dateParts[1]);
			int year = Integer.parseInt(dateParts[2]);

			if (isValidDate(month, day, year)) {
				this.month = month;
				this.day = day;
				this.year = year;
			} else {
				System.out.println("Invalid date " + s);
				System.exit(0);
			}
		} else {
			System.out.println("Invalid date " + s);
			System.exit(0);
		}
	}

	/**
	 * Checks whether the given year is a leap year.
	 * 
	 * @return true if and only if the input year is a leap year.
	 */
	public static boolean isLeapYear(int year) {
		if((year%4 == 0) && (year % 100 != 0)) {
			return true;
		} else if(year % 400 == 0) {
			return true;
		} else {
			return false;
		}
		
		
//		if (year % 4 != 0) {
//			return false;
//		} else if (year % 100 == 0) {
//			return false;
//		} else if (year % 400 == 0) {
//			return true;
//		} else {
//			return true;
//		}
	}

	/**
	 * Returns the number of days in a given month.
	 * 
	 * @param month
	 *            is a month, numbered in the range 1...12.
	 * @param year
	 *            is the year in question, with no digits omitted.
	 * @return the number of days in the given month.
	 */
	public static int daysInMonth(int month, int year) {
		int nDays = 0;

		switch (month) {
		case 1:
			nDays = 31;
			break;

		case 2:
			if (isLeapYear(year)) {
				nDays = 29;
			} else {
				nDays = 28;
			}
			break;

		case 3:
			nDays = 31;
			break;

		case 4:
			nDays = 30;
			break;

		case 5:
			nDays = 31;
			break;

		case 6:
			nDays = 30;
			break;

		case 7:
			nDays = 30;
			break;

		case 8:
			nDays = 31;
			break;

		case 9:
			nDays = 30;
			break;

		case 10:
			nDays = 31;
			break;

		case 11:
			nDays = 30;
			break;

		case 12:
			nDays = 31;
			break;

		default:
			nDays = -1;
			break;
		}

		return nDays;
	}

	/**
	 * Checks whether the given date is valid.
	 * 
	 * @return true if and only if month/day/year constitute a valid date.
	 *
	 *         Years prior to A.D. 1 are NOT valid.
	 */
	public static boolean isValidDate(int month, int day, int year) {
		boolean isDateValid = false;

		// Year validation check
		if (year >= 1) {
			int daysInMonth = daysInMonth(month, year);

			// Month validation check
			if (daysInMonth != -1) {
				// Check if input day in range
				if ((day >= 1) && (day <= daysInMonth)) {
					isDateValid = true;
				} else {
					isDateValid = false;
				}
			} else {
				isDateValid = false;
			}
		} else {
			isDateValid = false;
		}

		return isDateValid;
	}

	/**
	 * Returns a string representation of this date in the form month/day/year.
	 * The month, day, and year are expressed in full as integers; for example,
	 * 12/7/2006 or 3/21/407.
	 * 
	 * @return a String representation of this date.
	 */
	public String toString() {
		return (this.month + "/" + this.day + "/" + this.year);
	}

	/**
	 * Determines whether this Date is before the Date d.
	 * 
	 * @return true if and only if this Date is before d.
	 */
	public boolean isBefore(Date d) {
		boolean isBefore = false;

		if (this.year < d.getYear()) {
			isBefore = true;
		} else if (this.year == d.getYear()) {
			if (this.month < d.getMonth()) {
				isBefore = true;
			} else if (this.month == d.getMonth()) {
				if (this.day < d.getDay()) {
					isBefore = true;
				} else {
					isBefore = false;
				}
			} else {
				isBefore = false;
			}
		} else {
			isBefore = false;
		}

		return isBefore;
	}

	/**
	 * Determines whether this Date is after the Date d.
	 * 
	 * @return true if and only if this Date is after d.
	 */
	public boolean isAfter(Date d) {
		boolean isAfter = false;

		if (this.year > d.getYear()) {
			isAfter = true;
		} else if (this.year == d.getYear()) {
			if (this.month > d.getMonth()) {
				isAfter = true;
			} else if (this.month == d.getMonth()) {
				if (this.day > d.getDay()) {
					isAfter = true;
				} else {
					isAfter = false;
				}
			} else {
				isAfter = false;
			}
		} else {
			isAfter = false;
		}

		return isAfter;
	}

	/**
	 * Returns the number of this Date in the year.
	 * 
	 * @return a number n in the range 1...366, inclusive, such that this Date
	 *         is the nth day of its year. (366 is used only for December 31 in
	 *         a leap year.)
	 */
	public int dayInYear() {
		int dayInYear = 0;

		for (int i = 1; i < this.month; i++) {
			dayInYear += daysInMonth(i, this.year);
		}

		// Add the number of days for this.month
		dayInYear += this.day;

		return dayInYear;
	}

	/**
	 * Determines the difference in days between d and this Date. For example,
	 * if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1. If
	 * this Date occurs before d, the result is negative.
	 * 
	 * @return the difference in days between d and this date.
	 */
	public int difference(Date d) {
		int diff = 0;

		// Check if the dates belong to the same year.
		if (this.year == d.getYear()) {
			diff = this.dayInYear() - d.dayInYear();
		} else {
			if (this.isBefore(d)) {
				int diffInYears = d.getYear() - this.getYear();
				int currYear;

				for (int i = 1; i < diffInYears; i++) {
					currYear = this.getYear() + i;
					int numDaysInCurrYear = isLeapYear(currYear) ? 366 : 365;
					diff += numDaysInCurrYear;
				}

				int nDaysInThisYear = isLeapYear(this.getYear()) ? 366 : 365;
				diff += nDaysInThisYear - this.dayInYear();
				diff += d.dayInYear();

				diff *= -1;
			} else if (this.isAfter(d)) {
				int diffInYears = this.getYear() - d.getYear();
				int currYear;

				for (int i = 1; i < diffInYears; i++) {
					currYear = d.getYear() + i;
					int numDaysInCurrYear = isLeapYear(currYear) ? 366 : 365;
					diff += numDaysInCurrYear;
				}

				int nDaysInDYear = isLeapYear(d.getYear()) ? 366 : 365;
				diff += nDaysInDYear - d.dayInYear();
				diff += this.dayInYear();
			} else {
				diff = 0;
			}
		}

		return diff;
	}

	public static void main(String[] argv) {
		System.out.println("\nTesting constructors.");
		Date d1 = new Date(1, 1, 1);
		System.out.println("Date should be 1/1/1: " + d1);
		d1 = new Date("2/4/2");
		System.out.println("Date should be 2/4/2: " + d1);
		d1 = new Date("2/29/2000");
		System.out.println("Date should be 2/29/2000: " + d1);
		d1 = new Date("2/29/1904");
		System.out.println("Date should be 2/29/1904: " + d1);

		d1 = new Date(12, 31, 1975);
		System.out.println("Date should be 12/31/1975: " + d1);
		Date d2 = new Date("1/1/1976");
		System.out.println("Date should be 1/1/1976: " + d2);
		Date d3 = new Date("1/2/1976");
		System.out.println("Date should be 1/2/1976: " + d3);

		Date d4 = new Date("2/27/1977");
		Date d5 = new Date("8/31/2110");

		/* I recommend you write code to test the isLeapYear function! */

		System.out.println("\nTesting before and after.");
		System.out.println(d2 + " after " + d1 + " should be true: "
				+ d2.isAfter(d1));
		System.out.println(d3 + " after " + d2 + " should be true: "
				+ d3.isAfter(d2));
		System.out.println(d1 + " after " + d1 + " should be false: "
				+ d1.isAfter(d1));
		System.out.println(d1 + " after " + d2 + " should be false: "
				+ d1.isAfter(d2));
		System.out.println(d2 + " after " + d3 + " should be false: "
				+ d2.isAfter(d3));

		System.out.println(d1 + " before " + d2 + " should be true: "
				+ d1.isBefore(d2));
		System.out.println(d2 + " before " + d3 + " should be true: "
				+ d2.isBefore(d3));
		System.out.println(d1 + " before " + d1 + " should be false: "
				+ d1.isBefore(d1));
		System.out.println(d2 + " before " + d1 + " should be false: "
				+ d2.isBefore(d1));
		System.out.println(d3 + " before " + d2 + " should be false: "
				+ d3.isBefore(d2));

		System.out.println("\nTesting difference.");
		System.out.println(d1 + " - " + d1 + " should be 0: "
				+ d1.difference(d1));
		System.out.println(d2 + " - " + d1 + " should be 1: "
				+ d2.difference(d1));
		System.out.println(d3 + " - " + d1 + " should be 2: "
				+ d3.difference(d1));
		System.out.println(d3 + " - " + d4 + " should be -422: "
				+ d3.difference(d4));
		System.out.println(d5 + " - " + d4 + " should be 48762: "
				+ d5.difference(d4));
	}
}
