package facades;

import dto.BankCustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getBankCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }
    
    public BankCustomerDTO getBankCustomerByID(Long id) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery result = em.createQuery("SELECT b FROM BankCustomer b WHERE b.id = :id", BankCustomer.class);
            result.setParameter("id", id);
            BankCustomer customer = (BankCustomer) result.getSingleResult();
            BankCustomerDTO dto = new BankCustomerDTO(customer);
            return dto;
        } finally {
            em.close();
        }
    }
    
    public List<BankCustomer> getBankCustomerByName(String firstName){
        EntityManager em = emf.createEntityManager();
            try{
                TypedQuery<BankCustomer> query = em.createQuery("SELECT b FROM BankCustomer b WHERE b.firstName = :firstName",BankCustomer.class)
                        .setParameter("firstName", firstName);
                return query.getResultList();
            }finally {
                em.close();
            }
        }
    
    public BankCustomer addBankCustomer(BankCustomer customer){
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
    
    
    public List<BankCustomer> getAllBankCustomers(){
        EntityManager em = getEntityManager();
        try {
            List<BankCustomer> employees = em.createQuery("SELECT b from BankCustomer b").getResultList();
            return employees;
        } finally {
            em.close();
        }
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
