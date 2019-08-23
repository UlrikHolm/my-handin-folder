/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Animal;
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
@Path("animal")
public class AnimalResource {
    private static Animal animal = new Animal("Duck", 10, "Quack");
    private static Animal animal2 = new Animal("Dog", 5, "Wuf");
    private static Animal animal3 = new Animal("Cat", 3, "Meow");
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }
    
    @Path("/random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandom() {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);
        Random random = new Random();
        Animal randAnimal = animals.get(random.nextInt(animals.size()));
        return randAnimal.toString();
    }
    //Content-Type: text/html
    
   

    /**
     * Retrieves representation of an instance of duerdum.rest.intro.day3.exercises.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello from my first web service";
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
