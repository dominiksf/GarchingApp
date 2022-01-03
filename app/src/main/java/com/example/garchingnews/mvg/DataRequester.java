package com.example.garchingnews.mvg;

import android.os.Build;
import android.util.JsonReader;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.jsoup.*;

import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataRequester implements Runnable {

    public List<DepartureItem> depatureItemList = new ArrayList<>();

    public String url = "http://www.mvg-live.de/ims/dfiStaticAuswahl.svc?haltestelle=garching&ubahn=checked";

    public void chooseStation(String stationName) {
        try {
            stationName = URLEncoder.encode(stationName, "ISO-8859-1");


        } catch (UnsupportedEncodingException s) {

            Log.e("Encoding", "Encoding during MVG request failed.");

        }
    }

    public void startRequest() {

        String text = getText();

        System.out.println(text);

    }

    public void getDepartures() {


        try {

            Document doc = Jsoup.connect(url).get();


            if (doc.select("td:contains(Es wurde kein Bahnhof mit diesem Namen gefunden.)").first() != null) {
                Log.e("DataRequester", "Station not found");
            }

            Element content = doc.select("table").get(0);
            Elements rows = content.select("tbody").select("tr");

            for (Element row : rows) {

                if (row.className().equals("rowOdd") || row.className().equals("rowEven")) {
                    Elements cols = row.select("td");
                    depatureItemList.add(new DepartureItem(cols.get(1).text(), Integer.valueOf(cols.get(2).text())));

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getText() {

        try {

            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine = null;

            do {
                inputLine = in.readLine();
                response.append(inputLine + "\n");

            } while (inputLine != null);

            in.close();

            return response.toString();

        } catch (MalformedURLException e) {

            Log.e("DataRequester", "Invalid URL");

        } catch (IOException e) {

            Log.e("DataRequester", "IOException: " + e.getStackTrace());
        }

        return null;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {

        DataRequester d = new DataRequester();

        d.getDepartures();

        if (!d.depatureItemList.isEmpty()) {
            for (DepartureItem dI : d.depatureItemList) {

                System.out.println(dI.destination + " | Abfahrt in " + dI.departure + " Minuten.");

            }
        } else {
            Log.d("DepartureRQ", "Departure List is empty");
        }


    }


    public List<DepartureItem> getDepatureItemList() {
        return depatureItemList;
    }


    @Override
    public void run() {

        this.getDepartures();

    }
}
