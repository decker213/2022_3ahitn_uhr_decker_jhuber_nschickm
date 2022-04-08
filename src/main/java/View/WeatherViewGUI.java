package View;
import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;

import com.example.uhr_decker_jhuber_nschickm.HelloController;
import com.google.gson.Gson;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.Scanner;






/**
 * @author jhuber
 * Ändert den Text des Labels, welches das Wetter ausgibt.
 */
public class WeatherViewGUI {

    private BorderPane mainpane;

    protected Label cityname;
    protected Label wetter;
    protected Label temperatur;
    protected TextField stadt;
    protected Button abfragen;

    /**
     * Konstruktor
     *
     * @param cityname      das Label was zu ändern ist
     * @param temperatur das Label was zu ändern ist
     * @param wetter     das Label was zu ändern ist
     */
    public WeatherViewGUI(BorderPane mainpane, Label cityname, Label wetter, Label temperatur, TextField stadt, Button abfragen) {
        this.mainpane = mainpane;
        this.cityname = cityname;
        this.wetter = wetter;
        this.temperatur = temperatur;
        this.stadt = stadt;
        this.abfragen = abfragen;

        cityname.setVisible(false);
        wetter.setVisible(false);
        temperatur.setVisible(false);
    }




    /**
     * Ändert das Label
     *
     * @param stadt Wetter auf das geändert werden soll
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

            for (int j = 0; j < 1; j++) {

                double min = root.list.get(i).main.getTempMin() - 273.15;
                double min1 = Math.rint(min * 100) / 100;

                cityname.setVisible(true);
                wetter.setVisible(true);
                temperatur.setVisible(true);
                abfragen.setVisible(false);



               cityname.setText(root.city.getName());
                wetter.setText(root.list.get(i).weather.get(j).getMain());
                temperatur.setText(String.valueOf(min1));
            }

        }

        mainpane.setCenter(view);
    }


}

