package rest.service;

import com.google.gson.Gson;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employee")
public class EmployeeResource {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
    private static Gson gson = new Gson();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllEmployees() {
        List<Employee> employees = facade.getAllEmployees();
        return gson.toJson(employees);
    }
    
    @Path("highestpaid")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeesWithHighestSalary() {
        List<Employee> employees = facade.getEmployeesWithHighestSalary();
        return gson.toJson(employees);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
    @Path("/{id}")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public String getBankCustomerById(@PathParam("id") int id) {
    Employee employee = facade.getEmployeeById(id);
    return gson.toJson(employee);
}
    
    @Path("name/{name}")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public String getEmployeeByName(@PathParam("name") String name) {
    List<Employee> employees = facade.getEmployeeByName(name);
    return gson.toJson(employees);
}
    
}
