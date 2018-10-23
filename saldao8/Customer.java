package saldao8;

/**
 * Skriver ut texten "Hej Värld!"
 * 
 * @author Salim Daoud, saldao-8
 */

import java.util.ArrayList;

public class Customer
{
    private String firstName, lastName, personalIdentityNumber;
    //private int personalIdentityNumber; todo number or string?
    private ArrayList<SavingsAccount> accounts = new ArrayList<SavingsAccount>(); // todo here or constructor?
    
    public Customer(String firstName, String lastName, String personalIdentityNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
    }
    
    public void changeFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void changeLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public String getLastName()
    {
        return this.lastName;
    }
    
    public String getPersonalIdentityNumber()
    {
        return this.personalIdentityNumber;
    }
    
    public int createSavingsAccount()
    {
        SavingsAccount account = new SavingsAccount();
        this.accounts.add(account);
        
        return account.getAccountId();
    }
    
    public ArrayList<String> deleteAccounts()
    {//todo this.accounts addition
        
        ArrayList<String> deletedAccountsInfo = new ArrayList<String>();
        for (int i = 0; i < accounts.size(); i++)
        {
            deletedAccountsInfo.add(accounts.get(i).getAccountInfo() + " " + Double.toString(accounts.get(i).getInterest()));
        }
        
        this.accounts.clear();
        
        return deletedAccountsInfo; 
    }
    
    public String deleteAccount(int accountId)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            if (accounts.get(i).getAccountId() == accountId)
            {
                String deletedAccountInfo = accounts.get(i).getAccountInfo() + " " + Double.toString(accounts.get(i).getInterest());
                this.accounts.remove(i);
                
                return deletedAccountInfo;
            }
        }
        
        return null;
    }
    
    public String getAccount(int accountId)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            if (accounts.get(i).getAccountId() == accountId)
            {
                return accounts.get(i).getAccountInfo();
            }
        }
        
        return null;     
    }
    
    public ArrayList<Integer> getAccountIds()
    {
        ArrayList<Integer> accountIds = new ArrayList<Integer>();
        for (int i = 0; i < accounts.size(); i++)
        {
            accountIds.add(accounts.get(i).getAccountId());
        }
        
        return accountIds;     
    }
    
    public boolean deposit(int accountId, double amount)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            if (accounts.get(i).getAccountId() == accountId)
            {
                accounts.get(i).deposit(amount);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean withdraw(int accountId, double amount)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            if (accounts.get(i).getAccountId() == accountId)
            {
                return accounts.get(i).withdraw(amount);
            }
        }
        
        return false;
    }
    
    // todo mer metoder krävs
    
    /*static public void main(String[] args)
    {
        Customer c = new Customer("Salim","Daoud", "198111130376");
        System.out.println(c.getPersonalIdentityNumber());
      
    }*/
}
