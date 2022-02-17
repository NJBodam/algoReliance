import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try{
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try{
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();
                if (line != null) {
                    line = line.substring(line.indexOf("["), line.indexOf("]"));
                    line = line.substring(1).replace("\"", "").replace(",", ", ");
                    System.out.println(line);
                }

            }catch (IOException ioEx){
            }
        }catch(IOException ioEx){
            System.out.println(ioEx);
        }
    }
}
