package rest.service;

import entities.BankCustomer;
import facades.BankCustomerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.BankCustomerDTO;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;


@Path("bankcustomer")
public class BankCustomerResource {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    BankCustomerFacade facade =  BankCustomerFacade.getBankCustomerFacade(emf);
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
       
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllBankCustomers() {
        List<BankCustomer> bc = facade.getAllBankCustomers();
        return gson.toJson(bc);
    }
    
    @Path("name/{name}")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public String getBankCustomerByName(@PathParam("name") String name) {
    List<BankCustomer> bc = facade.getBankCustomerByName(name);
    return gson.toJson(bc);
    }
        
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomerDTO(@PathParam("id") int id) {
        return gson.toJson(facade.getBankCustomerByID(Long.valueOf(id)));
    }
        
}
