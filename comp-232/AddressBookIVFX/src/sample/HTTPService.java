package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HTTPService {

    private static String json = "";
    private static Gson gson = new Gson();

    public static ArrayList<Contact> getContactsList() {
        json = "";
        ArrayList<Contact> contacts;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/list");
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                json += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        Type contactListType = new TypeToken<ArrayList<Contact>>(){}.getType();
        contacts = gson.fromJson(reader, contactListType);
        return contacts;
    }

    public static void addContact(Contact newContact) {
        String json = gson.toJson(newContact);
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/add");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);
            OutputStream os = urlConnection.getOutputStream();
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    public static void deleteContact(Contact oldContact) {
        String json = gson.toJson(oldContact);
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/delete");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);
            OutputStream os = urlConnection.getOutputStream();
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    public static void updateContact(Contact oldContact, Contact newContact) {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(oldContact);
        contacts.add(newContact);
        String json = gson.toJson(contacts);
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/update");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);
            OutputStream os = urlConnection.getOutputStream();
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
