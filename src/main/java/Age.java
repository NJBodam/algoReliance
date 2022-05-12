import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                System.out.println(text);
                text = text.replace("{", "").replace("}", "")
                        .replace("\"","");
                int count = 0;

                String[] arr = text.split(", ");

                // SOLUTION 1
                int total = (int) Arrays.stream(arr).filter(x -> x.contains("age=")).collect(Collectors.toList())
                        .stream().filter(x -> Integer.parseInt(x.replace("age=", "")) >= 50).count();
                System.err.println(total);

                // SOLUTION 2
                for (int i = 1; i < arr.length; i++) {
                    if (i % 2 != 0) {
                        int num = Integer.parseInt(arr[i].replace("age=", ""));
                        count = num >= 50 ? count + 1 : count;
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
