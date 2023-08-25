/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mybank;

/**
 *
 * @author erani
 */
public class SavingAccount implements Account{
      private String SAC; 
    private double balance; 
    private double interest; 

    public SavingAccount(String SAC, double balance, double interest) {
        this.SAC = SAC;
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

    public String getSAC() {
        return SAC;
    }

    public void setSAC(String SAC) {
        this.SAC = SAC;
    }

    public void applyInterest() {
        balance += balance * interest/100; 
       // System.out.println("Balance ="+balance);
    }

    @Override
    public String toString() {
        return "SavingAccount{" + "SAC=" + SAC + ", balance=" + balance + ", interest=" + interest + '}';
    }

}
