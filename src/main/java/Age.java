import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Age {
    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String text = bufferedReader.readLine();
                text = text.replace("{", "").replace("}", "")
                        .replace("\"","");
                String[] arr = text.split(", ");
                String tempText ="";
                int count = 0;
                for (int i = 0; i<arr.length; i++){
                    if (arr[i].contains("age=")){
                        tempText = arr[i].substring(arr[i].indexOf("=")+1);
                        if (Integer.parseInt(tempText)>= 50){
                            count++;
                        }
                    }
                }

                System.out.println(count);

            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}
