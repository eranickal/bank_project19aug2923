/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.ArrayList;
import mybank.Bank;
import mybank.ContractorEmployee;
import mybank.Customer;
import mybank.IndividualCustomer;
import mybank.BusinessCustomer;

import mybank.Employee;
import mybank.FullTiimeEmployee;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author erani
 */
public class BankTest {
    Bank bank;
    Employee e1;
    Employee e2;
    Customer c1;
    Customer c2;
    public BankTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        bank = new Bank();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    @Test
    public void testBank(){
        bank = new Bank (1, "ABC", "2222", null,null);
       
        assertEquals(bank.getId(), 1);
        assertEquals(bank.getName(), "ABC");
        assertEquals(bank.getPhone(), "2222");
        assertNull(bank.getEmployees());
        assertNull(bank.getCustomers());
    }
    @Test
    public void testBankEmployee(){
        //new bank
       
        ArrayList <Employee> employeeList = new ArrayList<Employee>();
       
        Employee e1 = new FullTiimeEmployee(2000, 1, "tom" , "tom@abc.com");
        Employee e2 = new ContractorEmployee(30, 1, "jamin" , "jamin@abc.com");
       
        employeeList.add(e1);
        employeeList.add(e2);
        
         ArrayList<Customer> customerList = new ArrayList<Customer>();
         
         Customer c1 = new IndividualCustomer("4",1,"mat","era","mat@abc.com","345087322");
        Customer c2 = new BusinessCustomer ("1",1,"amy","scott","amy@abc.com","123456789");
        
        customerList.add(c1);
        customerList.add(c2);
        bank = new Bank(1, "ABC", "2222" , employeeList,customerList);
       
        assertNotNull(bank.getEmployees());
        assertEquals(bank.getEmployees().size(), 2);
        assertEquals(bank.getEmployees().get(0).getName(), "tom");
        assertEquals(  ( (ContractorEmployee) (bank.getEmployees().get(1) ) ).getHourlyRate() ,30.0f);
        
        assertNotNull(bank.getCustomers());
        
    }
}
