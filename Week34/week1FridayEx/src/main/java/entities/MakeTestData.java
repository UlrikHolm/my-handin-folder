/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ulrik
 */
public class MakeTestData {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        
        EntityManager em = emf.createEntityManager();
        BankCustomer b1 = new BankCustomer("Arne", "Hansen", "123456", 1500, 3, "Han er mega sej");
        BankCustomer b2 = new BankCustomer("Henry", "Madsen", "789456", 6000, 2, "Bruger masser af penge");
        BankCustomer b3 = new BankCustomer("Knud", "Jensen", "456120", 2360, 2, "Hedder Knud?");
        try{
            em.getTransaction().begin();
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.getTransaction().commit();
            
        }finally{
            em.close();
        }
        System.out.println("B1: " + b1.toString());
        
    }
    
}
