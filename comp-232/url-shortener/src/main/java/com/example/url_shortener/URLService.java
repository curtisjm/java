package com.example.url_shortener;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Random;

@Path("/service")
public class URLService {

    private static HashMap<String, String> map = new HashMap<>();
    private Gson gson = new Gson();

    @POST
    @Path("/url")
    public Response shortenURL(String json) {
        String url = gson.fromJson(json, String.class);
        StringBuilder newURL = new StringBuilder();
        String charsStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] chars = charsStr.toCharArray();
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            newURL.append(chars[rand.nextInt(60)]);
        }
        map.put(newURL.toString(), url);
        System.out.println(newURL);
        return Response.status(200).entity(gson.toJson(newURL)).build();
    }

    @GET
    @Path("/url/{id}")
    public Response expandURL(@PathParam("id") String id) {
        System.out.println("Here");
        map.put("test", "jdklsajflkasjdf");
        String url = gson.toJson(map.get(id));
        return Response.status(200).entity(url).build();
    }
}