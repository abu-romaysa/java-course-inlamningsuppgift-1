package saldao8;

/**
 * This class implements the bank logic that manages customers
 * and their accounts
 * 
 * @author Salim Daoud, saldao-8
 */

import java.util.ArrayList;

public class BankLogic
{
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    
    /**
     * Constructor
     */
    public BankLogic()
    {
    }
    
    /**
     * Provides a list of information about all the customers in the bank system
     * @return a list of strings containing information about all the customers
     */
    public ArrayList<String> getAllCustomers()
    {
        ArrayList<String> customersInfo = new ArrayList<String>();
        
        for(Customer customer : customers)
        {
            customersInfo.add(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPersonalIdentityNumber());
        }
        
        return customersInfo;
    }
    
    /**
     * Creates and adds a new customer to the bank system
     * @param firstName - new customer's first name
     * @param lastName - new customer's last name
     * @param personalIdentityNumber - new customer's personal identity number
     * @return true if the customer could be created
     */
    public boolean createCustomer(String firstName, String lastName, String personalIdentityNumber)
    {
        boolean customerCreated = false;
        
        Customer customer = findCustomer(personalIdentityNumber);
        if(customer == null)
        {
            Customer newCustomer = new Customer(firstName, lastName, personalIdentityNumber);
            customers.add(newCustomer);
            customerCreated = true;
        }
        
        return customerCreated;
    }
    
    /**
     * Provides information about a customer and her accounts
     * @param personalIdentityNumber - belonging to the customer of interest
     * @return list of strings containing information about the customer and 
     *         her accounts
     */
    public ArrayList<String> getCustomer(String personalIdentityNumber)
    {  
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            ArrayList<String> customerInfo = new ArrayList<String>();
            customerInfo.add(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPersonalIdentityNumber());
                     
            for(Integer accountId : customer.getAccountIds())
            {
                customerInfo.add(customer.getAccount(accountId));
            }
  
            return customerInfo;
        }
        
        return null;
    }
    
    /**
     * Changes a customer's first and last name
     * @param firstName - first name to change to
     * @param lastName - last name to change to
     * @param personalIdentityNumber - belonging to the customer of interest
     * @return true if the customer's full name could be changed
     */
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
    
    /**
     * Deletes the customer from the bank system
     * @param personalIdentityNumber - belonging to the customer of interest
     * @return string containing information about the removed customer and her
     *         removed accounts, otherwise null if the customer could not be 
     *         deleted
     */
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
    
    /**
     * Closes a customer account
     * @param personalIdentityNumber - belonging to the customer of interest 
     * @param accountId - account ID to remove
     * @return string containing information about the customer's closed account, 
     *         otherwise null if it could not be closed 
     */
    public String closeAccount(String personalIdentityNumber, int accountId)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        {
            return customer.removeAccount(accountId);
        }
        
        return null;
    }
    
    
    /**
     * Creates a saving account for a customer
     * @param personalIdentityNumber - belonging to the customer of interest
     * @return the account ID for the created account, otherwise the value -1
     *         if it couldn't create an account 
     */
    public int createSavingsAccount(String personalIdentityNumber)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.createSavingsAccount();
        }
        
        return -1;
    }

    /**
     * Provides information about a customer's account
     * @param personalIdentityNumber - belonging to the customer of interest
     * @param accountId - the account ID in question
     * @return string containing information about the customer's account, otherwise null 
     *         if it could not be found
     */
    public String getAccount(String personalIdentityNumber, int accountId)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.getAccount(accountId);
        }
        
        return null;
    }    

    /**
     * Deposits the amount to the customer's account
     * @param personalIdentityNumber - belonging to the customer to deposit to
     * @param accountId - account ID to deposit to
     * @param amount - the amount to deposit
     * @return true if the amount could be deposit
     */
    public boolean deposit(String personalIdentityNumber, int accountId, double amount)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.deposit(accountId, amount);
        }
        
        return false;
    }
    
    /**
     * Withdraws the amount from the customer's account
     * @param personalIdentityNumber - belonging to the customer to withdraw from
     * @param accountId - account ID to withdraw from
     * @param amount - the amount to withdraw
     * @return true if the amount could be withdrawn
     */
    public boolean withdraw(String personalIdentityNumber, int accountId, double amount)
    {
        Customer customer = findCustomer(personalIdentityNumber);
        if (customer != null)
        { 
            return customer.withdraw(accountId, amount);
        }
        
        return false;
    }

    /**
     * Searches for a customer with a specific personal identity number
     * @param personalIdentityNumber - personal identity number to lookup
     * @return the customer with a specific personal identity number, 
     *         otherwise null if the customer could not be found
     */
    private Customer findCustomer(String personalIdentityNumber)
    {  
        for(Customer customer : customers)
        {
            if(customer.getPersonalIdentityNumber() == personalIdentityNumber)
            {
                return customer;
            }
        }
        
        return null;
    }    
    
}
