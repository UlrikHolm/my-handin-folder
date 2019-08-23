/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ulrik
 */
public class Animal {
    
    private String type;
    private int age;
    private String sound;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    
    

    public Animal() {
    }

    public Animal(String type, int age, String sound) {
        this.type = type;
        this.age = age;
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal{" + "type=" + type + ", age=" + age + ", sound=" + sound + '}';
    }
    
    
    
    
    
}
