/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mybank;

/**
 *
 * @author erani
 */
public class BusinessCustomer extends Customer{
    private String ein;

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public BusinessCustomer(String ein, int CID, String fname, String lname, String email, String phone) {
        super(CID, fname, lname, email, phone);
        this.ein = ein;
    }
   
    public String toString() {
        return "BusinessCustomer{" + "ein=" + ein + " "+ super.toString() + '}';
    }
    
}
