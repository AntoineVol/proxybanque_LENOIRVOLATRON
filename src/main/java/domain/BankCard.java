package domain;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class BankCard implements Entity, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private TypeBankCard typeBankCard;
	private Integer numBankCard;
	private LocalDate expirationDate;
	private CurrentAccount currentAccount;
	
	//GETTER & SETTER
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumBankCard() {
		return numBankCard;
	}
	public void setNumBankCard(Integer numBankCard) {
		this.numBankCard = numBankCard;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public TypeBankCard getTypeBankCard() {
		return typeBankCard;
	}
	public void setTypeBankCard(TypeBankCard typeBankCard) {
		this.typeBankCard = typeBankCard;
	}
	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}
	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}
	

}
