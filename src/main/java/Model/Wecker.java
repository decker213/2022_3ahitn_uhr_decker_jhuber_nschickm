package Model;

import java.io.*;
import java.sql.Time;


public class Wecker {

    private String time;

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
