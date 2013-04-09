/**
 * 
 */
package org.openntf.domino.ext;

import java.util.Calendar;

/**
 * @author nfreeman
 * 
 */
public interface DateTime {

	/**
	 * Compares current date with another and returns boolean of whether they are the same.
	 * 
	 * @param comparDate
	 *            DateTime to compare to current date
	 * @return boolean, whether or not the two dates are the same
	 */
	public boolean equals(org.openntf.domino.DateTime comparDate);

	/**
	 * @param comparDate
	 *            DateTime to compare to the current DateTime
	 * @return boolean is time is the same, including millisecond
	 */
	public boolean equalsIgnoreDate(org.openntf.domino.DateTime comparDate);

	/**
	 * @param comparDate
	 *            DateTime to compare to the current DateTime
	 * @return boolean is date is the same
	 */
	public boolean equalsIgnoreTime(org.openntf.domino.DateTime comparDate);

	/**
	 * Compares current date with another and returns boolean of whether current date is after parameter.
	 * 
	 * @param comparDate
	 *            DateTime to compare to current date
	 * @return boolean, whether or not current date is after the parameter
	 */
	public boolean isAfter(org.openntf.domino.DateTime comparDate);

	/**
	 * Compares current date with another and returns boolean of whether current date is before parameter.
	 * 
	 * @param comparDate
	 *            DateTime to compare to current date
	 * @return boolean, whether or not current date is before the parameter
	 */
	public boolean isBefore(org.openntf.domino.DateTime comparDate);

	/**
	 * @return Java Calendar object, same as used internally by org.openntf.domino.DateTime class
	 */
	public Calendar toJavaCal();
}