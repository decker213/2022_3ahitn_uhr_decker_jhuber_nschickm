package View ;


import java.sql.Time;

/**
 * @author david
 */
public class DigitalViewConsole extends ViewInterface
{
	/**
	 * Gibt die Zeit aus
 	 * @param time Zeit in EU - Format
	 */
	public void display(Time time) {
		System.out.println(time);
	}
}

