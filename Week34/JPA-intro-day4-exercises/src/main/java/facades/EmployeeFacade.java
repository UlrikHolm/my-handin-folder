package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
      
    private EmployeeFacade() {
    }

    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }
    
    public Employee createEmployee(String name, String adress, int salary){
        Employee employee = new Employee(Long.MIN_VALUE, name, adress, salary);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        }finally {
            em.close();
        }
    }
    
    public Employee getEmployeeById(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Employee employee = em.find(Employee.class,id);
            return employee;
        }finally {
            em.close();
        }
    }   
    
    public List<Employee> getEmployeesWithHighestSalary(){
        EntityManager em = getEntityManager();
        try {
            List<Employee> employees = em.createQuery("SELECT MAX(e.salary) from Employee e").getResultList();
            return employees;
        } finally {
            em.close();
        }
    }
    
    public List<Employee> getAllEmployees(){
        EntityManager em = getEntityManager();
        try {
            List<Employee> employees = em.createQuery("SELECT e from Employee e").getResultList();
            return employees;
        } finally {
            em.close();
        }
    }
    
    public List<Employee> getEmployeeByName(String name){
        EntityManager em = emf.createEntityManager();
            try{
                TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name",Employee.class)
                        .setParameter("name", name);
                return query.getResultList();
            }finally {
                em.close();
            }
        }
    

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
