package Model;

import java.io.*;
import java.sql.Time;

/**
 * @author Nico
 */
public class Wecker {


    private String time;

    File wecker;
    /**
     * Die eingegebe Weckzeit wird in das WeckerTime.txt gespeichert
     *
     * @param time ist die eingegebene Weckzeit
     * @throws IOException
     */
    public void addWecker(String time) throws IOException {

        wecker = new File("WeckerTime");
        FileWriter fwWecker = new FileWriter(wecker);
        fwWecker.write(String.valueOf(time));

        fwWecker.close();

        }



    /**
     * @return true wenn die Uhrzeit gleich der Weckzeit ist
     * false wenn die Uhr ungleich der Weckzeit ist
     */
    public boolean iscurrentWecker() throws IOException {
        boolean rv = false;
        Time timenow = new Time(System.currentTimeMillis());

        String[] parts = timenow.toString().split(":");


        BufferedReader br = new BufferedReader(new FileReader(wecker));
        String st;
        String WeckTimeEintrag = null;
        while ((st = br.readLine()) != null) {
            WeckTimeEintrag = st;
            System.out.println("this " + WeckTimeEintrag);
        }

        System.out.println(parts[0]);
        System.out.println(time);
        if ((parts[0] + ":" + parts[1]).equals(String.valueOf(WeckTimeEintrag))) {
            System.out.println("true");
            rv = true;
        }else {
            System.out.println("false");
        }
        return rv;
    }


    public static void main(String[] args) throws IOException {

        Wecker w = new Wecker();
        w.addWecker("18:03");
        w.iscurrentWecker();
    }
}

