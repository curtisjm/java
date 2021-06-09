package WebService;

//Write a simple java web service that works as a URL shortener and expander.
//
//        Eg:
//        POST /url routes to the shorten operation.
//        GET /url/:id routes to the expand operation.


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClientTest {

    public static String shortenURL(String oldUrl) {
        String shortenedURL = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/url_shortener_war_exploded/finalexam/service/url");
            urlConnection = (HttpURLConnection) url.openConnection();

            Map<String, String> parameters = new HashMap<>();
            parameters.put("param1", "val");

            urlConnection.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
            urlConnection.setRequestProperty("Content-Type", "application/json");

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                shortenedURL += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return shortenedURL;
    }

    public static void main(String[] args) {
        System.out.println(shortenURL("test"));
    }

}
