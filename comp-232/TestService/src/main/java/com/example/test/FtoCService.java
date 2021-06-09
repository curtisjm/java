package com.example.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/ftocservice")
public class FtoCService {
    @GET
    @Produces("application/json")
    public Response convertFtoC() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Double farenheit = 98.24;
        Double celsius;
        celsius = (farenheit - 32) * 5 / 9 ;
        jsonObject.put("F Value", farenheit);
        jsonObject.put("C Value", celsius);
        String result = "@Produces(\"application/json\") Output: \n\n F to C Convertor Output: \n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }

    @Path("{f}")
    @GET
    @Produces("application/json")
    public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
        JSONObject jsonObj = new JSONObject();
        float celsius;
        celsius = (f - 32) * 5 / 9;
        jsonObj.put("F Value", f);
        jsonObj.put("C Value", celsius);
        String result = "@Produces(\"application/json\") Output: \n\n F to C Convertor Output: \n\n"
                + jsonObj;
        return Response.status(200).entity(result).build();
    }
}