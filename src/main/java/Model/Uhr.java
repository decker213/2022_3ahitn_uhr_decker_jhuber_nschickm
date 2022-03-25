package Model;

import java.sql.Time;
import java.util.Date;

/**
 * @author david
 * in der Uhr Klasse wird die aktuelle Zeit im eu- und us- Format und das aktuelle Datum gespeichert
 * mit den getter kann auf die einzelnen Zeiten/ das Datum zugegriffen werden
 * die Zeit wird im Konstruktor im eu-Format gesetzt
 */
public class Uhr {
    private Time zeit_eu;
    private Time zeit_us;
    private Date datum;

    public Uhr(Time zeit_eu, Date datum) {
        this.zeit_eu = zeit_eu;
        this.datum = datum;
    }

    public Time getZeit_eu() {
        return zeit_eu;
    }

    public Time getZeit_us() {
        if (zeit_eu.getHours() % 12 != 0) {
            zeit_us = new Time(zeit_eu.getTime() - 43200000);
        } else {
            zeit_us = new Time(zeit_eu.getTime());
        }
        return zeit_us;
    }

    public Date getDatum() {
        return datum;
    }
}
