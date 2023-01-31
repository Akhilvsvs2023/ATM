package atm;

public class Customer 
{
	private String pin;
	public int balance;
	public void cashDeposit(int depositAmount)
	{
		balance = balance + depositAmount;
		System.out.println("*** Cash Deposited ***");
	}
	public void cashWithdrawl(int withdrawlAmount)
	{
		balance = balance - withdrawlAmount;
		System.out.println("*** Cash Withdrawn ***");
	}
	public int balanceEnquiry()
	{
		return balance;
	}
	public void setPin(String pin)
	{
		if(pin.length()==4)
		{
			this.pin = pin;
			System.out.println("**** Pin set successfully ****");
			System.out.println();
		}
		else
		{
			System.out.println("The pin should be 4 digits ");
			System.out.println();
		}
	}
	public String getPin()
	{
		return pin;
	}
}
