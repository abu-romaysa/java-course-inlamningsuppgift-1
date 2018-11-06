package saldao8;

/**
 * This class implements a customer and manages the customer's information and
 * accounts
 * 
 * @author Salim Daoud, saldao-8
 */

import java.util.ArrayList;

public class Customer
{
    private String firstName, lastName, personalIdentityNumber;
    private ArrayList<SavingsAccount> accounts = new ArrayList<SavingsAccount>();

    /**
     * Constructor
     * 
     * @param firstName - new customer's first name
     * @param lastName - new customer's last name
     * @param personalIdentityNumber - new customer's personal identity number
     */
    public Customer(String firstName, String lastName, String personalIdentityNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
    }

    /**
     * Changes the customer's first name
     * 
     * @param firstName - name to change to
     */
    public void changeFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Changes the customer's last name
     * 
     * @param lastName - name to change to
     */
    public void changeLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Provides the customer's first name
     * 
     * @return string containing the customer's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Provides the customer's last name
     * 
     * @return string containing the customer's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Provides the customer's personal identity number
     * 
     * @return string containing the customer's personal identity number
     */
    public String getPersonalIdentityNumber()
    {
        return personalIdentityNumber;
    }

    /**
     * Creates a saving account for the customer
     * 
     * @return the account ID for the created account
     */
    public int createSavingsAccount()
    {
        SavingsAccount account = new SavingsAccount();
        accounts.add(account);

        return account.getAccountId();
    }

    /**
     * Deletes all the accounts that belongs to the customer
     * 
     * @return string containing information about the customer's deleted
     *         accounts
     */
    public ArrayList<String> deleteAccounts()
    {
        ArrayList<String> deletedAccountsInfo = new ArrayList<String>();

        for(SavingsAccount account : accounts)
        {
            deletedAccountsInfo.add(account.toString() + " " + Double.toString(account.getInterest()));
        }

        accounts.clear();

        return deletedAccountsInfo;
    }

    /**
     * Removes the customer's account
     * 
     * @param accountId - account ID to remove
     * @return string containing information about the customer's deleted
     *         account, otherwise null if it could not be deleted
     */
    public String removeAccount(int accountId)
    {
        SavingsAccount account = findAccount(accountId);
        if(account != null)
        {
            String deletedAccountInfo = account.toString() + " " + Double.toString(account.getInterest());
            accounts.remove(account);

            return deletedAccountInfo;
        }

        return null;
    }

    /**
     * Provides information about a customer's account
     * 
     * @param accountId - the account ID in question
     * @return string containing information about the customer's account,
     *         otherwise null if it could not be found
     */
    public String getAccount(int accountId)
    {
        SavingsAccount account = findAccount(accountId);
        if(account != null)
        {
            return account.toString();
        }

        return null;
    }

    /**
     * Provides the customer's account IDs
     * 
     * @return list with account IDs belonging to the customer
     */
    public ArrayList<Integer> getAccountIds()
    {
        ArrayList<Integer> accountIds = new ArrayList<Integer>();

        for(SavingsAccount account : accounts)
        {
            accountIds.add(account.getAccountId());
        }

        return accountIds;
    }

    /**
     * Deposits the amount to the customer's account
     * 
     * @param accountId - account ID to deposit to
     * @param amount - the amount to deposit
     * @return true if the amount could be deposit
     */
    public boolean deposit(int accountId, double amount)
    {
        SavingsAccount account = findAccount(accountId);
        if(account != null)
        {
            account.deposit(amount);
            return true;
        }

        return false;
    }

    /**
     * Withdraws the amount from the customer's account
     * 
     * @param accountId - account ID to withdraw from
     * @param amount - the amount to withdraw
     * @return true if the amount could be withdrawn
     */
    public boolean withdraw(int accountId, double amount)
    {
        SavingsAccount account = findAccount(accountId);
        if(account != null)
        {
            return account.withdraw(amount);
        }

        return false;
    }

    /**
     * Provides presentation information about the customer
     * 
     * @return string containing information about the customer
     */
    public String toString()
    {
        return firstName + " " + lastName + " " + personalIdentityNumber;
    }

    /**
     * Searches for an account with a specific account ID
     * 
     * @param accountId - account ID to lookup
     * @return the account with a specific account ID, otherwise null if the
     *         account could not be found
     */
    private SavingsAccount findAccount(int accountId)
    {
        for(SavingsAccount account : accounts)
        {
            if(account.getAccountId() == accountId)
            {
                return account;
            }
        }

        return null;
    }

}
