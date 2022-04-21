package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;

import com.google.gson.Gson;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


/**
 * @author nschickm
 * Ändert den Text die Labels,auf die Daten der eingegebenen Stadt
 */
public class WeatherViewGUI {

    private BorderPane mainpane;

    protected Label wetter;
    protected Label temperatur;
    protected TextField stadt;
    protected Label date;

    /**
     * Konstruktor
     *
     * @param wetter     Wetter setzen
     * @param temperatur Temperatur setzen
     * @param date       Datum setzen
     */
    public WeatherViewGUI(BorderPane mainpane, Label wetter, Label temperatur, TextField stadt, Label date) {
        this.mainpane = mainpane;
        this.wetter = wetter;
        this.temperatur = temperatur;
        this.stadt = stadt;
        this.date = date;

        wetter.setVisible(false);
        temperatur.setVisible(false);
        date.setVisible(false);
    }


    /**
     * Ändert das Label
     *
     * @param stadt die von dieser Stadt sollen Ausgegeben werden
     */
    public void display(String stadt) throws IOException {


        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("WeatherTemp.fxml");

        stadt = stadt.replaceAll("//s", "+");

        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + stadt + ",at&appid=d134cb284ef6ebbab66ea57a6b83f4f8\n");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        Scanner scanner = new Scanner(con.getInputStream());

        StringBuilder stringBuilder = new StringBuilder("");

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        Gson gson = new Gson();
        Root root = gson.fromJson(stringBuilder.toString(), Root.class);


        for (int i = 0; i < 1; i++) {

            String datum[] = root.list.get(i).dtTxt.split("-");
            String tag[] = datum[2].split(" ");
            for (int j = 0; j < 1; j++) {

                double min = root.list.get(i).main.getTempMin() - 273.15;
                double min1 = Math.rint(min * 100) / 100;


                wetter.setVisible(true);
                temperatur.setVisible(true);
                date.setVisible(true);

                wetter.setText(root.list.get(i).weather.get(j).getMain());
                temperatur.setText(String.valueOf(min1));
                date.setText(tag[0] + "." + datum[1] + "." + datum[0]);
            }

        }

        mainpane.setCenter(view);
    }


}

