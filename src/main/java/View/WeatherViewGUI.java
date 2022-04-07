package View;


import com.google.gson.Gson;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @author jhuber
 * Ändert den Text des Labels, welches das Wetter ausgibt.
 */
public class WeatherViewGUI  {

    protected Label stadt;
    protected Label wetter;
    protected Label temperatur;

    /**
     * Konstruktor
     *
     * @param stadt      das Label was zu ändern ist
     * @param temperatur das Label was zu ändern ist
     * @param wetter     das Label was zu ändern ist
     */
    public WeatherViewGUI(Label stadt, Label wetter, Label temperatur) {
        this.stadt = stadt;
        this.wetter = wetter;
        this.temperatur = temperatur;
    }

    /**
     * Ändert das Label
     *
     * @param cityname Wetter auf das geändert werden soll
     */
    public void display(String cityname) throws IOException {

        cityname = cityname.replaceAll("//s", "+");

        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + cityname + ",at&appid=d134cb284ef6ebbab66ea57a6b83f4f8\n");

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

                stadt.setText(root.city.getName());
                wetter.setText(root.list.get(i).weather.get(j).getMain());
                temperatur.setText(String.valueOf(min1));
            }

        }
    }

}

