/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mybank;

/**
 *
 * @author erani
 */
public class IndividualCustomer extends Customer{
    private String  ssn;

    public IndividualCustomer(String ssn, int CID, String fname, String lname, String email, String phone) {
        super(CID, fname, lname, email, phone);
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "IndividualCustomer{" + "ssn=" + ssn +" "+ super.toString() + '}';
    }
    
    

    
    
}
