package Model;

import java.util.TimeZone;

/**
 * @author david
 */
public class Zeitzone {

    private TimeZone timeZone;

    public Zeitzone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Berechnet die Zeitverschiebung zwischen der in der Klasse gespeicherten Zeitzone und der mitgegebenen Zeitzone
     *
     * @param zeitzone Zeitzone, zu der die Verschiebung berechnet werden soll
     * @return gibt die Verschiebung zu der Start-Zeitzone in Millisekunden zurück
     */
    public long calc(TimeZone zeitzone) {
        return timeZone.getRawOffset() - zeitzone.getRawOffset();
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }
}

