/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ulrik
 */
public class CustomerFacade {
    
     private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {}

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    
    public Customer addCustomer(String firstName, String lastName){
        Customer customer = new Customer(firstName,lastName);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        }finally {
            em.close();
        }
    }
    
    public Customer findCustomerById(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Customer customer = em.find(Customer.class,id);
            return customer;
        }finally {
            em.close();
        }
    }


    
    public List<Customer> getCustomerByLastName(String lastName){
        EntityManager em = emf.createEntityManager();
            try{
                TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer  c WHERE c.lastName = :lastName",Customer.class)
                        .setParameter("lastName", lastName);
                return query.getResultList();
            }finally {
                em.close();
            }

        }
    
    
    
    public Number getCustomerCount(){
            EntityManager em = emf.createEntityManager();
         try{
                Query q = em.createQuery("SELECT count(customer) FROM Customer customer");
                return (Number) q.getSingleResult();
           }finally {
               em.close();
           }    
    }

    
            
    public List<Customer> getAllCustomers(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("Select customer from Customer customer",Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }

    
}
