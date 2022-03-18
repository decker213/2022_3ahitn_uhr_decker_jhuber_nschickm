package Model;

import java.io.*;
import java.sql.Time;

/**
 * @author: Nico
 */
public class Wecker {


    private String time;

    /**
     * Die eingegebe Weckzeit wird in das WeckerTime.txt gespeichert
     *
     * @param time ist die eingegebene Weckzeit
     * @throws IOException
     */
    public void addWecker(String time) throws IOException {

        File wecker = new File("WeckerTime");
        FileWriter fwWecker = new FileWriter(wecker);
        fwWecker.write(String.valueOf(time));

        fwWecker.close();

        BufferedReader br = new BufferedReader(new FileReader(wecker));
        String st;
        while ((st = br.readLine()) != null)
            this.time = st;
    }

    /**
     * @return true wenn die Uhrzeit gleich der Weckzeit ist
     * false wenn die Uhr ungleich der Weckzeit ist
     */
    public boolean iscurrentWecker() {
        boolean rv = false;
        Time timenow = new Time(System.currentTimeMillis());

        String[] parts = timenow.toString().split(":");

        if ((parts[0] + ":" + parts[1]).equals(String.valueOf(time))) {
            rv = true;
        }
        return rv;
    }

}
