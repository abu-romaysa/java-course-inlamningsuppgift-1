package saldao8;

/**
 * This class implements a saving account and it's needed support and management
 * as transactions, account information etc.
 * 
 * @author Salim Daoud, saldao-8
 */

public class SavingsAccount
{
    private double balance;
    private static double interestRate;
    private int accountId;
    private final static String ACCOUNT_TYPE = "Saving account";
    private static int accountIdCounter = 1001;

    /**
     * Constructor
     */
    public SavingsAccount()
    {
        // assign an accountId and accumulate the counter that handles Ids
        accountId = accountIdCounter;
        accountIdCounter += 1;

        balance = 0;
        interestRate = 1;
    }

    /**
     * Deposits the amount to the account
     * 
     * @param amount - the amount to deposit
     */
    public void deposit(double amount)
    {
        balance += amount;
    }

    /**
     * Withdraws the amount from the account if the full amount exists
     * 
     * @param amount - the amount to withdraw
     * @return true if amount is withdrawn otherwise false
     */
    public boolean withdraw(double amount)
    {
        if((balance - amount) < 0)
        {
            return false;
        }

        balance -= amount;
        return true;
    }

    /**
     * Provides the account ID for this account
     * 
     * @return account ID
     */
    public int getAccountId()
    {
        return accountId;
    }

    /**
     * Provides the amount of interest
     * 
     * @return amount of interest
     */
    public double getInterest()
    {
        return (balance * (interestRate / 100));
    }

    /**
     * Provides presentation information about the account
     * 
     * @return string containing information about the account
     */
    public String toString()
    {
        return Integer.toString(accountId) + " " + Double.toString(balance) + " " + ACCOUNT_TYPE + " "
                + Double.toString(interestRate);
    }

}
