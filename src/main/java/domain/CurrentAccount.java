package domain;

public class CurrentAccount extends BankAccount{
	private BankCard bankCard;
	
	//GETTER & SETTER
	public BankCard getBankCard() {
		return bankCard;
	}
	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}
}
