/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mybank;

/**
 *
 * @author erani
 */
public class CheckingAccount implements Account{
      private String CAC; 
    private double balance; 
    private double interest; 

    public CheckingAccount(String CAC, double balance, double interest) {
        this.CAC = CAC;
        this.balance = balance;
        this.interest = interest;
    }
    
    @Override
    public void deposit(double amount) {
       balance += amount; 
    }

    @Override
    public void withdraw(double amount) {
       balance -= amount; 
    }

    @Override
    public double getBalance() {
        return balance; 
    }

    public String getCAC() {
        return CAC;
    }

    public void setSAC(String CAC) {
        this.CAC = CAC;
    }

    public void applyInterest() {
        balance += balance * interest/100; 
    }

    @Override
    public String toString() {
        return "CheckingAccount{" + "CAC=" + CAC + ", balance=" + balance + ", interest=" + interest + '}';
    }

    
}
