package com.example.AddressBookIVService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

@Path("/abservice")
public class ABService {

    MySQL sqlObj = MySQL.getInstance();

    @GET
    @Path("/list")
    public Response listContacts() {
        String json = sqlObj.makeList();
        return Response.status(200).entity(json).build();
    }

    @POST
    @Path("/add")
    public Response addContact(String json) {
        sqlObj.addContact(json);
        return Response.status(200).entity(json).build();
    }

    @POST
    @Path("/delete")
    public Response deleteContact(String json) {
        sqlObj.deleteContact(json);
        return Response.status(200).entity(json).build();
    }

    @POST
    @Path("/update")
    public Response updateContact(String json) {
        sqlObj.updateContact(json);
        return Response.status(200).entity(json).build();
    }

}