package Model;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author david
 */
public class Timer {

    /**
     * Wartet die angegebene Zeit bis zu 0 und gibt dann true zurück
     * @param t in dem Paramater wird die Zeit in Millisekunden angegeben, wie lang der Timer dauern soll
     * @return sobald die angegebene Zeit abgelaufen ist, wird true zurückgegeben
     * @throws InterruptedException
     */
    public boolean timerstart(Time t) throws InterruptedException {
        boolean r = false;

        for (int i = 0; i <= t.getTime() / 1000; i++) {
            TimeUnit.SECONDS.sleep(1);
        }

        return r;
    }
}

