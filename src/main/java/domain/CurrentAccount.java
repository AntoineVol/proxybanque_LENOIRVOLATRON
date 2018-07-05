package domain;

import java.io.Serializable;

public class CurrentAccount extends BankAccount implements Entity, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BankCard bankCard;
	
	//GETTER & SETTER
	public BankCard getBankCard() {
		return bankCard;
	}
	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}
}
