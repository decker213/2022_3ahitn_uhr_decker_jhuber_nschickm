package Model;


import com.google.gson.Gson;

import View.Root;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main1 {


    public static void main(String[] args) throws IOException {


        String cityname= null;
        Scanner scannerCity = new Scanner(System.in);
        System.out.println("Aktuelle Stadt eingeben:");
        cityname = scannerCity.nextLine();
        cityname = cityname.replaceAll(" ", "+");

        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + cityname + ",at&appid=d134cb284ef6ebbab66ea57a6b83f4f8\n");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        Scanner scanner = new Scanner(con.getInputStream());

        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }


        Gson gson = new Gson();
        Root root = gson.fromJson(stringBuilder.toString(), Root.class);
        System.out.println("Ort: " + root.city.getName());

        for (int i = 0; i < 1; i++) {

            for (int j = 0; j < 1; j++) {

                double min = root.list.get(i).main.getTempMin()-273.15;
                double max = root.list.get(i).main.getTempMax()-273.15;
                double min1=Math.rint(min*100)/100;
                double max1=Math.rint(max*100)/100;
                System.out.println("Temperatur: " + min1);


            }
        }

    }
}


