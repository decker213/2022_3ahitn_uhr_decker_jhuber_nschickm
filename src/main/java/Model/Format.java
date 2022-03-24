package Model;

import javafx.scene.paint.Color;

/**
 * @author david
 * speichert die Daten zu dem aktuellen Format
 */
public class Format {
    private Color color;
    private Boolean sekunden;
    private String schriftart;
    private Boolean datum;

    public Format(Color color, Boolean sekunden, String schriftart, Boolean datum, String us_eu) {
        this.color = color;
        this.sekunden = sekunden;
        this.schriftart = schriftart;
        this.datum = datum;
        this.us_eu = us_eu;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getSekunden() {
        return sekunden;
    }

    public void setSekunden(Boolean sekunden) {
        this.sekunden = sekunden;
    }

    public String getSchriftart() {
        return schriftart;
    }

    public void setSchriftart(String schriftart) {
        this.schriftart = schriftart;
    }

    public Boolean getDatum() {
        return datum;
    }

    public void setDatum(Boolean datum) {
        this.datum = datum;
    }

    public String getUs_eu() {
        return us_eu;
    }

    public void setUs_eu(String us_eu) {
        this.us_eu = us_eu;
    }

    private String us_eu;
}
