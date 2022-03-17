package Model;

import java.sql.Time;
import java.util.Date;

/**
 * @author david
 */
public class Uhr {
    private Time zeit_eu;
    private Time zeit_us;
    private Date datum;

    public Uhr(Time zeit_eu, Time zeit_us, Date datum) {
        this.zeit_eu = zeit_eu;
        this.zeit_us = zeit_us;
        this.datum = datum;
    }

    public Time getZeit_eu() {
        return zeit_eu;
    }

    public Time getZeit_us() {
        return zeit_us;
    }

    public Date getDatum() {
        return datum;
    }
}
