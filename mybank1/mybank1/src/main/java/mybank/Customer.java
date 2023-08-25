/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mybank;

/**
 *
 * @author erani
 */
public class Customer {
     private int CID;
    private String fname;
    private String lname;
    private String email;
    private String phone;

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "CID=" + CID + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", phone=" + phone + '}';
    }

    
    public Customer(int CID, String fname, String lname, String email, String phone) {
        this.CID = CID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }
    
    
}
