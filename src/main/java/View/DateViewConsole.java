package View ;


import java.util.Date;

/**
 * @author david
 */
public class DateViewConsole extends ViewInterface
{
	/**
	 * Gibt ein Datum aus
	 * @param date Datum, welches ausgegeben wird
	 */
	public void display(Date date) {
		System.out.println(date);
	}
}

