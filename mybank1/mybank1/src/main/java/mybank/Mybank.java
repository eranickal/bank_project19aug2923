/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author itexps
 */
public class Mybank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        //empty employee list
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<SavingAccount> Saccounts = new ArrayList<SavingAccount>();
        ArrayList<CheckingAccount> Caccounts = new ArrayList<CheckingAccount>();
        //create a bank with empty employee list
        Bank bank = new Bank(1, "IT Expert Bank", "847 350 9034", employees, customers, Saccounts, Caccounts);

        do {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("== Add employee==");
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    System.out.println("Enter name");
                    String name = sc.next();

                    System.out.println("Enter email");
                    String email = sc.next();

                    System.out.println("Employee type");
                    String type = sc.next();
                    Employee emp1 = null;
                    if (type.equalsIgnoreCase("fulltime")) {
                        //create employee instance with data
                        System.out.println("Enter salary");
                        float salary = sc.nextFloat();
                        emp1 = new FullTiimeEmployee(salary, id, name, email);
                    } else {
                        System.out.println("Enter hourly rate");
                        float hourlyrate = sc.nextFloat();
                        emp1 = new ContractorEmployee(hourlyrate, id, name, email);
                    }

                    //add employee in a bank
                    bank.getEmployees().add(emp1);
                    System.out.println(bank);
                    break;
                case 2:
                    System.out.println("== Search employee == ");
                    System.out.println("Enter employee id ");
                    int eid = sc.nextInt();
                    boolean found = false;
                    for (Employee e : bank.getEmployees()) {
                        if (e.getId() == eid) {
                            System.out.println(e);
                            found = true;
                            break;
                        }
                    }
                    if (found == false) {
                        System.out.println("For this id - Employee does not exit");
                    }
                    break;
                case 3:
                    System.out.println("Save Employee");
                    try {
                        FileWriter fw = new FileWriter("C:\\Users\\erani\\OneDrive\\Desktop\\BankProject\\bank,txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("===========Bank ============\n");
                        bw.write(bank.getId() + "|" + bank.getName() + "|" + bank.getPhone() + "\n");

                        bw.write("===========Employee[s] ============\n");

                        for (Employee e : bank.getEmployees()) {

                            bw.write(e.getId() + "|" + e.getName() + "|" + e.getEmail());
                            if (e instanceof FullTiimeEmployee) {
                                bw.write(((FullTiimeEmployee) e).getSalary() + "");
                            } else {
                                bw.write(((ContractorEmployee) e).getHourlyRate() + "");
                            }
                            bw.write("\n");

                        } //for

                        //TODO For Customer
                        //Each Customer has account
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("== Add customer==");
                    System.out.println("Enter id");
                    int CID = sc.nextInt();
                    System.out.println("Enter First name");
                    String fname = sc.next();
                    System.out.println("Enter Last name");
                    String lname = sc.next();
                    System.out.println("Enter email");
                    String cemail = sc.next();
                    System.out.println("Enter phone");
                    String phone = sc.next();

                    // Customer cust1 = new Customer(CID, fname, lname, cemail, phone);
                    //bank.getCustomers().add(cust1);
                    System.out.println("Customer type");
                    String ctype = sc.next();
                    Customer cust1 = null;
                    if (ctype.equalsIgnoreCase("Individual")) {
                        //create employee instance with data
                        System.out.println("Enter SSN");
                        String ssn = sc.next();
                        cust1 = new IndividualCustomer(ssn, CID, fname, lname, cemail, phone);
                    } else {
                        System.out.println("Enter EIN");
                        String ein = sc.next();
                        cust1 = new BusinessCustomer(ein, CID, fname, lname, cemail, phone);
                    }
                    //add employee in a bank
                    bank.getCustomers().add(cust1);

                    System.out.println(bank);
                    break;

                case 5:
                    System.out.println("== Search customer == ");
                    System.out.println("Enter customer id ");
                    int CID1 = sc.nextInt();
                    boolean found1 = false;
                    for (Customer c : bank.getCustomers()) {
                        if (c.getCID() == CID1) {
                            System.out.println(c);
                            found1 = true;
                            break;
                        }
                    }
                    if (found1 == false) {
                        System.out.println("For this id - Customer does not exit");
                    }
                    break;

                case 6:
                    System.out.println("Save Custome");
                    try {
                        FileWriter fw = new FileWriter("C:\\Users\\erani\\OneDrive\\Desktop\\BankProject\\bank,txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("===========Bank ============\n");
                        bw.write(bank.getId() + "|" + bank.getName() + "|" + bank.getPhone() + "\n");

                        //int CID, String fname, String lname, String email, String phone
                        bw.write("===========Customer[s] ============\n");

                        for (Customer c : bank.getCustomers()) {

                            bw.write(c.getCID() + "|" + c.getFname() + "|" + c.getLname() + "|" + c.getEmail() + "|" + c.getEmail() + "|" + c.getPhone() + "|");
//                            if (c instanceof FullTiimeEmployee) {
//                                bw.write(((FullTiimeEmployee) c).getSalary() + "");
//                            } else {
//                                bw.write(((ContractorEmployee) c).getHourlyRate() + "");
//                            }
                            bw.write("\n");

                        } //for

                        //TODO For Customer
                        //Each Customer has account
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                    case 7:
                    System.out.println("== Add account==");
                    System.out.println("Enter type of the account");
                    String atype = sc.next();
                   // Customer cust1 = null;
                    if (atype.equalsIgnoreCase("Savings")) {
                        //create account instance with data
                        System.out.println("Enter SAC");
                        String SAC = sc.next();
                        System.out.println("Enter balance");
                        double balance = sc.nextDouble(); 
                        System.out.println("Enter interest rate");
                        double interest = sc.nextDouble(); 
                        SavingAccount acc1 = new SavingAccount(SAC, balance, interest); 
                        bank.getSaccounts().add(acc1);
                    } else {
                        System.out.println("Enter CAC");
                        String CAC = sc.next();
                        System.out.println("Enter balance");
                        double balance = sc.nextDouble(); 
                        System.out.println("Enter interest rate");
                        double interest = sc.nextDouble(); 
                        CheckingAccount acc1 = new CheckingAccount(CAC, balance, interest); 
                        bank.getCaccounts().add(acc1);
                    }
                    //add employee in a bank
                    //bank.getCustomers().add(cust1);

                    System.out.println(bank);

//
//                    // Customer cust1 = new Customer(CID, fname, lname, cemail, phone);
//                    //bank.getCustomers().add(cust1);
//                    System.out.println("Customer type");
//                    
                      break;
           case 8:
                    System.out.println("== Search Account  == ");
                    System.out.println("Enter type of the account");
                    String t = sc.next();
                    boolean founda = false;
                    if (t.equalsIgnoreCase("Savings")) {
                    System.out.println("Enter savings account number");
                    String a = sc.next();
                    for (SavingAccount c : bank.getSaccounts()) {
                        if (a.equalsIgnoreCase(c.getSAC())) {
                            System.out.println(c);
                            founda = true;
                            break;
                        }
                    } 
                    }
                    else if (t.equalsIgnoreCase("Checking")){
                    System.out.println("Enter checking account number");
                    String a = sc.next();
                    for (CheckingAccount c : bank.getCaccounts()) {
                        if (a.equalsIgnoreCase(c.getCAC())) {
                            System.out.println(c);
                            founda = true;
                            break;
                            }
                    }
                    }
                    if (founda == false) {
                        System.out.println("For this id - Account does not exit");
                    }
                    break;

                case 9:
                    System.out.println("Save Savings Account");
                    try {
                        FileWriter fw = new FileWriter("C:\\Users\\navat\\OneDrive\\Desktop\\bootcamp\\Java projects\\account.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("===========Bank ============\n");
                        bw.write(bank.getId() + "|" + bank.getName() + "|" + bank.getPhone() + "\n");

                        //int CID, String fname, String lname, String email, String phone
                        bw.write("===========Account[s] ============\n");

                        for (SavingAccount c : bank.getSaccounts()) {

                            bw.write(c.getSAC() + "|" + c.getBalance() + "|");
//                            if (c instanceof FullTiimeEmployee) {
//                                bw.write(((FullTiimeEmployee) c).getSalary() + "");
//                            } else {
//                                bw.write(((ContractorEmployee) c).getHourlyRate() + "");
//                            }
                            bw.write("\n");

                        } //for

                        //TODO For Customer
                        //Each Customer has account
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                 
                     case 10:
                    System.out.println("Save Checking Account");
                    try {
                        FileWriter fw = new FileWriter("C:\\Users\\navat\\OneDrive\\Desktop\\bootcamp\\Java projects\\account.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("===========Bank ============\n");
                        bw.write(bank.getId() + "|" + bank.getName() + "|" + bank.getPhone() + "\n");

                        //int CID, String fname, String lname, String email, String phone
                        bw.write("===========Account[s] ============\n");

                        for (CheckingAccount c : bank.getCaccounts()) {

                            bw.write(c.getCAC() + "|" + c.getBalance() + "|");
//                            if (c instanceof FullTiimeEmployee) {
//                                bw.write(((FullTiimeEmployee) c).getSalary() + "");
//                            } else {
//                                bw.write(((ContractorEmployee) c).getHourlyRate() + "");
//                            }
                            bw.write("\n");

                        } //for

                        //TODO For Customer
                        //Each Customer has account
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    

                case 12:
                    break;
            

        
            
            } } while (choice != 12);
            
        
       

    public static void menu() {
        System.out.println("1 for Add Employee");
        System.out.println("2 for Search Employee");
        System.out.println("3 for Save Employee");

        System.out.println("4 for Add Customer");
        System.out.println("5 for Search Customer");
        System.out.println("6 for Save Customer");

        System.out.println("7 for Add Account");
        System.out.println("8 for Search Account");
        System.out.println("9 for Save Savings Account");
        System.out.println("10 for Save Checking Account");

        System.out.println("12 for Quit");
        System.out.println("Enter your choice  ");
            }
        }     
}



