package Model;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * @author david
 */
public class Stoppuhr {
    private Time start = null;
    private boolean end = false;

    /**
     * Misst den Zeitabstand zwischen zwei Aufrufen der Methode
     *
     * @return wenn "click" das erste mal aufgerufen wird, wird NULL zurueckgegeben,
     * beim zweiten Mal die Differenz zwischen dem ersten und dem zweiten "click"
     */
    public Time click() {
        Time r = null;

        if (start == null) {
            start = new Time(System.currentTimeMillis());
        } else {
            r = new Time(System.currentTimeMillis() - start.getTime());
            start = null;
            end = true;
        }

        return r;
    }

    public Time getStart() {
        return start;
    }

    public boolean getEnd() {
        return end;
    }

}

