package atm;
import java.util.Scanner;
public class NetBanking 
{
	public static void main(String[] args) 
	{
		Scanner scan  = new Scanner(System.in);
		Customer c1 = new Customer();		
		int count = 0;
		while(c1.getPin()==null)
		{
			System.out.println(" Set the 4 digit pin : ");
			String pin = scan.next();
			c1.setPin(pin);
		}
		while(count < 3)
		{
			System.out.println();
			System.out.println("****Select the options from below**** ");
			System.out.println();
			System.out.println("1 Cash Deposit");
			System.out.println("2 Cash Withdrawl");
			System.out.println("3 Balance Enquiry");
			System.out.println("4 Change Pin");
			System.out.println("5 Exit");
			int option = scan.nextInt();
			if(option == 1)
			{
				System.out.println(" Enter the amount to be deposited ");
				int depositAmount = scan.nextInt();
				System.out.println(" Enter 4 digit pin ");
				String pin = scan.next();
				if(pin.equals(c1.getPin()))
				{
					count = 0;
					c1.cashDeposit(depositAmount);	
				}
				else
				{
					count++;
					System.out.println(" The pin is inccorrect. " + (3-count) +" tries left");
				}
			}
			else if(option == 2)
			{
				System.out.println(" Enter the amount to be withdrawn ");
				int withdrawlAmount = scan.nextInt();
				System.out.println(" Enter 4 digit pin ");
				String pin = scan.next();
				if(pin.equals(c1.getPin()))
				{
					count = 0;
					if(withdrawlAmount<=c1.balance)
					{
						c1.cashWithdrawl(withdrawlAmount);
					}
					else
					{
						System.out.println(" Insufficient Balance ");
					}					
				}
				else
				{
					count++;
					System.out.println(" The pin is inccorrect. " + (3-count) +" tries left");					
				}
			}
			else if(option == 3)
			{
				System.out.println(" Enter 4 digit pin ");
				String pin = scan.next();
				if(pin.equals(c1.getPin()))
				{
					count = 0;
					System.out.println(" Account Balance : "+c1.balanceEnquiry());
				}
				else
				{
					count++;
					System.out.println(" The pin is inccorrect. " + (3-count) +" tries left");					
				}
			}
			else if(option == 4)
			{
				System.out.println(" Enter the old 4 digit pin ");
				String pin = scan.next();
				if(pin.equals(c1.getPin()))
				{
					count = 0;
					System.out.println(" Enter the new 4 digit pin ");
					String newPin = scan.next();
					System.out.println(" Confirm the new 4 digit pin ");
					String confirmNewPin = scan.next();
					if(newPin.equals(c1.getPin()))
					{
						System.out.println(" New Pin is same as old pin");
						continue;
					}
					if(newPin.equals(confirmNewPin))
					{
						c1.setPin(newPin);
					}
					else
					{
						System.out.println(" The pin are not matched");
					}
				}
				else
				{
					count++;
					System.out.println(" The pin is inccorrect. " + (3-count) +" tries left");					
				}
				
			}
			else if(option == 5)
			{
				break;
			}
			else
			{
				System.out.println(" Enter valid option");
			}			
		}		
	}
}
