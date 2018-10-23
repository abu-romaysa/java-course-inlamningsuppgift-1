package saldao8;

/**
 * Skriver ut texten "Hej Värld!"
 * 
 * @author Salim Daoud, saldao-8
 */

public class SavingsAccount
{
    private double balance, interestRate; 
    private int accountId;
    final String accountType = "Saving account"; //todo final best?
    static int accountIdCounter = 1001;
    
    public SavingsAccount()
    {
        this.accountId = accountIdCounter;
        accountIdCounter+=1;
        
        this.balance = 0;
        this.interestRate = 1; // todo final?
    }
    
    public void deposit(double amount)
    {
        this.balance += amount;
    }   

    public boolean withdraw(double amount)
    {
        if ( (this.balance - amount) < 0)
        {
            return false;
        }
        
        this.balance -= amount;
        return true;
    }
    
    public int getAccountId()
    {
        return this.accountId;
    }

    public double getInterest()
    {
        return (this.balance * (interestRate/100));
    }
    
    public String getAccountInfo()
    {
        return Integer.toString(this.accountId) + " " + Double.toString(this.balance) + " " + this.accountType + " " + Double.toString(this.interestRate);
    }

    /*static public void main (String[] args)
    {
        SavingsAccount sa0 = new SavingsAccount();
        System.out.println(sa0.getAccountInfo());
        
        /*System.out.println("test");
        
        System.out.println("============ 0");
        SavingsAccount sa0 = new SavingsAccount();
        sa0.print();
        
        System.out.println("============ 1");
        SavingsAccount sa1 = new SavingsAccount();
        sa1.print();
        
        System.out.println("============ 2");
        SavingsAccount sa2 = new SavingsAccount();
        sa2.print();
        
        System.out.println("============ delete 1");
        sa1 = null;
        
        System.out.println("============ 3");
        SavingsAccount sa3 = new SavingsAccount();
        sa3.print();
        
        
    }*/
}
