package ATM;

abstract class ATM {
    public double trxn_id;
	abstract double withDraw(int dispenseAmount);
	abstract double deposit(int amount);
	abstract int checkBalance();
	
	abstract int authentication(String userName, int passWord);
	public double generateTrxn_id(){
		return Math.random();
	}
	public double getTrxn_id(){
		return trxn_id;
	}
	public void setTrxn_id(double trxn_id){
		this.trxn_id = trxn_id;
	}
	
}
