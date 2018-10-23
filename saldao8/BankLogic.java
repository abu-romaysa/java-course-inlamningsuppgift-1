package saldao8;

/**
 * Skriver ut texten "Hej Värld!"
 * 
 * @author Salim Daoud, saldao-8
 */

import java.util.ArrayList;

public class BankLogic
{
    private ArrayList<Customer> customers = new ArrayList<Customer>(); // todo right way?
    
    public BankLogic()
    {
    }
    
    public ArrayList<String> getAllCustomers()
    {
        ArrayList<String> customersInfo = new ArrayList<String>();
        
        for (int i = 0; i < customers.size(); i++)
        {
            customersInfo.add(customers.get(i).getFirstName() + " " + customers.get(i).getLastName() + " " + customers.get(i).getPersonalIdentityNumber());
        }
        
        return customersInfo;
    }
    
    public boolean createCustomer(String firstName, String lastName, String personalIdentityNumber)
    {
        boolean customerAlreadyExists = false;
        
        for (int i = 0; i < customers.size(); i++)
        {
            if (customers.get(i).getPersonalIdentityNumber() == personalIdentityNumber)
            {
                customerAlreadyExists = true;
            }
        }
        
        if(!customerAlreadyExists)
        {
            Customer customer = new Customer(firstName, lastName, personalIdentityNumber);
            customers.add(customer);
            return true;
        }
        
        return false;
    }
    
    public ArrayList<String> getCustomer(String personalIdentityNumber)
    {  
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            ArrayList<String> customerInfo = new ArrayList<String>();
            customerInfo.add(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPersonalIdentityNumber());
            
            ArrayList<Integer> accounts = customer.getAccountIds();
            for (int i = 0; i < accounts.size(); i++)
            {
                customerInfo.add(customer.getAccount(accounts.get(i)));
            }
  
            return customerInfo;
        }
        
        return null;
    }
    
    public boolean changeCustomerName(String firstName, String lastName, String personalIdentityNumber)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        {
            customer.changeFirstName(firstName);
            customer.changeLastName(lastName);
            
            return true;
        }
        
        return false;
    }
    
    public ArrayList<String> deleteCustomer(String personalIdentityNumber)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        {
            ArrayList<String> deletedCustomerInfo = new ArrayList<String>();
            deletedCustomerInfo.add(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPersonalIdentityNumber());
  
            ArrayList<String> deletedCustomerAccounts = customer.deleteAccounts();
            deletedCustomerInfo.addAll(deletedCustomerAccounts);
            
            customers.remove(customer);
            
            return deletedCustomerInfo;
        }
        
        return null;
    }
    
    public String closeAccount(String personalIdentityNumber, int accountId)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        {
            return customer.deleteAccount(accountId);
        }
        
        return null;
    }
    
    public int createSavingsAccount(String personalIdentityNumber)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.createSavingsAccount();
        }
        
        return -1;
    }
   
    public String getAccount(String personalIdentityNumber, int accountId)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.getAccount(accountId);
        }
        
        return null;
    }
    
    private Customer findCustomer(String personalIdentityNumber)
    {
        for (int i = 0; i < customers.size(); i++)
        {
            if (customers.get(i).getPersonalIdentityNumber() == personalIdentityNumber)
            {
                return customers.get(i);
            }
        }
        
        return null;
    }
    
    public boolean deposit(String personalIdentityNumber, int accountId, double amount)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.deposit(accountId, amount);
        }
        
        return false;
    }
    
    public boolean withdraw(String personalIdentityNumber, int accountId, double amount)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.withdraw(accountId, amount);
        }
        
        return false;
    }

    /*static public void main(String[] args)
    {
        BankLogic bl = new BankLogic();
        boolean created = bl.createCustomer("S", "D", "8111130376");
        if (created) System.out.println("created");
        
        created = bl.createCustomer("S", "D", "8111130372");
        if (created) System.out.println("created"); else System.out.println("no");
        
        System.out.println("=============");
        
        System.out.println(bl.createSavingsAccount("8111130376"));
        System.out.println(bl.createSavingsAccount("8111130376"));
        
        System.out.println("=============");
        
        System.out.println(bl.getAccount("8111130376", 1001));
        
        System.out.println("=============");
        
        System.out.println(bl.deposit("8111130376", 1002, 100));
        System.out.println(bl.withdraw("8111130376", 1002, 10));
        
        System.out.println("=============");
        
        System.out.println(bl.getCustomer("8111130376"));
        
        System.out.println("=============");
        
        System.out.println(bl.changeCustomerName("H", "B", "8111130376"));
        System.out.println(bl.getCustomer("8111130376"));
        
        System.out.println("=============");
        
        //System.out.println(bl.deleteCustomer("8111130376"));
        System.out.println(bl.closeAccount("8111130376", 1002));
        System.out.println(bl.getCustomer("8111130376"));
        
    }*/
    
}
