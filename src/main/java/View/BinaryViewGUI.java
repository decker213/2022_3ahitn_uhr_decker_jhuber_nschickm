package View;


import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.sql.Time;

public class BinaryViewGUI {
    private BorderPane mainpane;

    public BinaryViewGUI(BorderPane borderPane) {
        mainpane = borderPane;
    }

    public void display(Time time) throws IOException {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("BinaryClock.fxml");

        // Kreise für Stunden zeichnen
        int counthour = 0;
        Circle[] circArrayHour = new Circle[6];
        for (int i = 0; i < 4; i++) {
            circArrayHour[i] = new Circle();
            circArrayHour[i].setRadius(20);
            circArrayHour[i].setCenterX(90);
            circArrayHour[i].setCenterY(40 * i);
            circArrayHour[i].setFill(Color.GRAY);
            counthour++;
            if (counthour == 4) {
                for (int i2 = 0; i2 < 2; i2++) {
                    i++;
                    circArrayHour[i] = new Circle();
                    circArrayHour[i].setRadius(20);
                    circArrayHour[i].setCenterX(40);
                    circArrayHour[i].setCenterY(80 + (40 * i2));
                    circArrayHour[i].setFill(Color.GRAY);
                }
            }
        }


        // Kreise für Minuten zeichnen
        int countMin = 0;
        Circle[] circArrayMin = new Circle[7];
        for (int o = 0; o < 4; o++) {
            circArrayMin[o] = new Circle();
            circArrayMin[o].setRadius(20);
            circArrayMin[o].setCenterX(200);
            circArrayMin[o].setCenterY(40 * o);
            circArrayMin[o].setFill(Color.GRAY);
            countMin++;
            if (countMin == 4) {
                for (int o2 = 0; o2 < 3; o2++) {
                    o++;
                    circArrayMin[o] = new Circle();
                    circArrayMin[o].setRadius(20);
                    circArrayMin[o].setCenterX(150);
                    circArrayMin[o].setCenterY(40 + (40 * o2));
                    circArrayMin[o].setFill(Color.GRAY);
                }
            }
        }

        // Kreise für Sekunden zeichnen
        int countSec = 0;
        Circle[] circArraySec = new Circle[7];
        for (int u = 0; u < 4; u++) {
            circArraySec[u] = new Circle();
            circArraySec[u].setRadius(20);
            circArraySec[u].setCenterX(310);
            circArraySec[u].setCenterY(40 * u);
            circArraySec[u].setFill(Color.GRAY);
            countSec++;
            if (countSec == 4) {
                for (int u2 = 0; u2 < 3; u2++) {
                    u++;
                    circArraySec[u] = new Circle();
                    circArraySec[u].setRadius(20);
                    circArraySec[u].setCenterX(260);
                    circArraySec[u].setCenterY(40 + (40 * u2));
                    circArraySec[u].setFill(Color.GRAY);
                }
            }
        }

        //Aktuelle Uhr Zeit hohlen und aufteilen in Stunde, Minuten und Sekunden

        String[] parts = time.toString().split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        int sec = Integer.parseInt(parts[2]);

        // Uhrzeit in Binär umwandeln
        int binsec = Integer.parseInt(Integer.toBinaryString(sec));
        int binmin = Integer.parseInt(Integer.toBinaryString(min));
        int binhour = Integer.parseInt(Integer.toBinaryString(hour));


        // System.out.println("---Hour---");
        // pruefen welcher Kreis (Stunden) farbig markiert werden soll
        int zehn = 10;
        int pruefhour = 0;
        int vier = 4;
        int zwanzig = 20;
        for (int i = 0; i < 2; i++) {
            if (Integer.parseInt(String.valueOf(binhour), 2) >= zwanzig) {
                int erg = Integer.parseInt(String.valueOf(binhour), 2) - zwanzig;
                binhour = Integer.parseInt(Integer.toBinaryString(erg));
                circArrayHour[vier].setFill(Color.LIGHTBLUE);
            }
            vier = vier + 1;
            zwanzig = zwanzig - 10;
        }
        for (int a = 3; a >= 0; a--) {
            pruefhour = binhour % 2;
            binhour = binhour / 10;
            if (pruefhour == 1) {
                circArrayHour[a].setFill(Color.LIGHTBLUE);
            }
        }

        // System.out.println("---Min---");
        // pruefen welcher Kreis (Minuten) farbig markiert werden soll
        int fuenfzigMin = 50;
        int pruefmin = 0;
        int binergMin = 0;
        int ergMin = 0;
        for (int i = 0; i < 3; i++) {

            if (Integer.parseInt(String.valueOf(binmin), 2) >= 10) {
                ergMin = Integer.parseInt(String.valueOf(binmin), 2) / 10;
                binergMin = Integer.parseInt(Integer.toBinaryString(ergMin));

                for (int j = 3; j > 0; j--) {
                    pruefmin = binergMin % 2;
                    binergMin = binergMin / 10;
                    if (pruefmin == 1) {
                        circArrayMin[j + 3].setFill(Color.LIGHTBLUE);
                    }
                }
                fuenfzigMin = fuenfzigMin - 10;
            }
        }
        binergMin = Integer.parseInt(Integer.toBinaryString(ergMin));
        binmin = Integer.parseInt(String.valueOf(binmin), 2) - (Integer.parseInt(String.valueOf(binergMin), 2) * 10);
        binmin = Integer.parseInt(Integer.toBinaryString(binmin));

        for (int a = 3; a >= 0; a--) {
            pruefmin = binmin % 2;
            binmin = binmin / 10;
            if (pruefmin == 1) {
                circArrayMin[a].setFill(Color.LIGHTBLUE);
            }
        }

        // System.out.println("---Sec---");
        // pruefen welcher Kreis (Sekunden) farbig markiert werden soll
        int fuenfzigSec = 50;
        int pruefsec = 0;
        int binergSec = 0;
        int ergSec = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(String.valueOf(binsec), 2) >= 10) {
                ergSec = Integer.parseInt(String.valueOf(binsec), 2) / 10;
                binergSec = Integer.parseInt(Integer.toBinaryString(ergSec));

                for (int j = 3; j > 0; j--) {
                    pruefsec = binergSec % 2;
                    binergSec = binergSec / 10;
                    if (pruefsec == 1) {
                        circArraySec[j + 3].setFill(Color.LIGHTBLUE);
                    }
                }
                fuenfzigSec = fuenfzigSec - 10;
            }
        }
        binergSec = Integer.parseInt(Integer.toBinaryString(ergSec));
        binsec = Integer.parseInt(String.valueOf(binsec), 2) - (Integer.parseInt(String.valueOf(binergSec), 2) * 10);
        binsec = Integer.parseInt(Integer.toBinaryString(binsec));

        for (int a = 3; a >= 0; a--) {
            pruefsec = binsec % 2;
            binsec = binsec / 10;
            if (pruefsec == 1) {
                circArraySec[a].setFill(Color.LIGHTBLUE);
            }
        }

        mainpane.getChildren().addAll(circArrayHour);
        mainpane.getChildren().addAll(circArrayMin);
        mainpane.getChildren().addAll(circArraySec);
        mainpane.setCenter(view);
    }
}

