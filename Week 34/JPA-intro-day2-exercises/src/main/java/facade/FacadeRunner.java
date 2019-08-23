/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ulrik
 */
public class FacadeRunner {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = facade.addCustomer("Per", "Andersen");
        facade.addCustomer("Knud", "Doe");
        facade.addCustomer("Ole", "Henriksen");
        facade.addCustomer("Per", "Doe");
        
        System.out.println("Found by ID: " + facade.findCustomerById(2));
        
        System.out.println("All Customers: ");
        List<Customer> customers = facade.getAllCustomers();
        for ( Customer c : customers){
            System.out.println(c.toString());
        }
        
        
        System.out.println("LN: " + facade.getCustomerByLastName("Doe"));
        
        System.out.println("Customer count: " + facade.getCustomerCount());
                
    }
    
}
