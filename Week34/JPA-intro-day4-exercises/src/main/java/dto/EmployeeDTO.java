/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Ulrik
 */
public class EmployeeDTO {
    private long id;
    private String name;
    private String adress;

    public EmployeeDTO(long id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public EmployeeDTO() {
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", adress=" + adress + '}';
    }
    
    
}


