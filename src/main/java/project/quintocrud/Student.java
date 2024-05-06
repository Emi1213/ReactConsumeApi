package project.quintocrud;


import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emi
 */
public class Student {
    @JsonProperty("cedula")
    private String ID;
    
    @JsonProperty("nombre")
    private String firstName;
    
    @JsonProperty("apellido")
    private String lastName;
    
    @JsonProperty("direccion")
    private String address;
    
    @JsonProperty("telefono")
    private String phone;
    
    
    public Student(){}

    public Student(String ID, String firstName, String lastName, String address, String phone) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
    
    
    
}
