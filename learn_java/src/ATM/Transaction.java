package ATM;

public class Transaction extends ATM{
	private int amount;
	private String userName;
	private int passWord;
	double getTrxn_id;
	public Transaction(String userName, int passWord, int amount){
		this.userName=userName;
		this.passWord=passWord;
		this.amount = amount;
	}
	int authentication(String userName, int passWord){
		if(this.userName == userName && this.passWord == passWord)
			return 1;
		else
			return 0;
	}
	double withDraw(int dispenseAmount){
	    	if(this.amount >= dispenseAmount){
				this.amount = this.amount - dispenseAmount;
				getTrxn_id = getTrxn_id();
			}
	    
		return getTrxn_id;
	}
	
	double deposit(int amount){
		if(this.amount >= 0){
			this.amount = this.amount + amount;
			getTrxn_id = getTrxn_id();
		}	
		return getTrxn_id;
	}
	
	int checkBalance(){
		return amount;
	}

}
