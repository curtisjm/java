import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HttpTest {

//    private ArrayList<Contact> contacts = new ArrayList<>();
//    private String json = "";
//    private Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        printContacts(HTTPService.getContactsList());
    }

    private static void printContacts(ArrayList<Contact> contacts) {
        for(Contact c : contacts) {
            System.out.println(c + "\n");
        }
    }

//    private void listContacts() {
//        HttpURLConnection urlConnection = null;
//        try {
//            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/list");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(
//                    urlConnection.getInputStream()));
//            String line;
//            while ((line = rd.readLine()) != null) {
//                json += line;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (urlConnection != null) {
//                urlConnection.disconnect();
//            }
//        }
//        Type contactListType = new TypeToken<ArrayList<Contact>>(){}.getType();
//        contacts = gson.fromJson(json, contactListType);
//    }
//
//    private void addContact() {
//        Contact newContact = new Contact("JavaJX", "FXLast", "FX here", "123FX");
//        String json = gson.toJson(newContact);
//        HttpURLConnection urlConnection = null;
//        try {
//            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/add");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setRequestProperty("Accept", "application/json");
//            urlConnection.setDoOutput(true);
//            OutputStream os = urlConnection.getOutputStream();
//            byte[] input = json.getBytes(StandardCharsets.UTF_8);
//            os.write(input, 0, input.length);
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (urlConnection != null) {
//                urlConnection.disconnect();
//            }
//        }
//    }
//
//    private void deleteContact() {
//        Contact newContact = new Contact();
//        newContact.setPhoneNumber("123FX");
//        String json = gson.toJson(newContact);
//        HttpURLConnection urlConnection = null;
//        try {
//            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/delete");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setRequestProperty("Accept", "application/json");
//            urlConnection.setDoOutput(true);
//            OutputStream os = urlConnection.getOutputStream();
//            byte[] input = json.getBytes(StandardCharsets.UTF_8);
//            os.write(input, 0, input.length);
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (urlConnection != null) {
//                urlConnection.disconnect();
//            }
//        }
//    }
//
//    private void updateContact() {
//        contacts.clear();
//        contacts.add(new Contact());
//        contacts.get(0).setPhoneNumber("123FX");
//        contacts.add(new Contact("2JavaJX2", "2FXLast2", "2FX here2", "123FX"));
//        String json = gson.toJson(contacts);
//        HttpURLConnection urlConnection = null;
//        try {
//            URL url = new URL("http://localhost:8080/AddressBookIVService_war_exploded/contacts/abservice/update");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setRequestProperty("Accept", "application/json");
//            urlConnection.setDoOutput(true);
//            OutputStream os = urlConnection.getOutputStream();
//            byte[] input = json.getBytes(StandardCharsets.UTF_8);
//            os.write(input, 0, input.length);
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (urlConnection != null) {
//                urlConnection.disconnect();
//            }
//        }
//    }

}
