/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ulrik
 */
@Path("customers")
public class CustomerResource {
    private static Customer customer = new Customer(1,"Per","Hansen");
    private static Customer customer2 = new Customer(2,"Kim","Larsen");
    private static Customer customer3 = new Customer(3,"Ib","Knudsen");

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }
    
    @Path("/random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandom() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);
        Random random = new Random();
        Customer randCust = customers.get(random.nextInt(customers.size()));
        return randCust.toString();
    }
    
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);
        return customers.toString();
           
        }
    
        @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomerById() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);
        return customers.toString();
           
        }
    

    /**
     * Retrieves representation of an instance of rest.CustomerResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello from my first web service";
    }

    /**
     * PUT method for updating or creating an instance of CustomerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
