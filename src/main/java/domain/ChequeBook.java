package domain;

import java.io.Serializable;
import java.time.LocalDate;

public class ChequeBook implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id;
	private LocalDate sendDate;
	private LocalDate receptionDate;
	private BankAccount bankAccount;
	
	
	//GETTER & SETTER
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getSendDate() {
		return sendDate;
	}
	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}
	public LocalDate getReceptionDate() {
		return receptionDate;
	}
	public void setReceptionDate(LocalDate receptionDate) {
		this.receptionDate = receptionDate;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}


	

}
