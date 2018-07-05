package domain;

import java.time.LocalDate;

public class ChequeBook {
	private Integer id;
	private LocalDate sendDate;
	private LocalDate receptionDate;
	private CurrentAccount currentAccount;
	
	
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
	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}
	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}
	

}
