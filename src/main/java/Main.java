import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();
                if (line != null) {
                    StringBuilder nwLine = new StringBuilder(line);
                    String hobbies = (nwLine.substring(nwLine.lastIndexOf("[") + 1, nwLine.length() - 2))
                            .replace("\",\"", ", ").replace("\"", "");
                    System.err.println(hobbies);
                }

            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
