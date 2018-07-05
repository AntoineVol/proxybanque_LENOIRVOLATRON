package domain;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class BankAccount implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer numAccount;
	private LocalDate creationDate;
	private Double balance;
	private ChequeBook checkBook;
	
	//GETTER & SETTER
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(Integer numAccount) {
		this.numAccount = numAccount;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public ChequeBook getCheckBook() {
		return checkBook;
	}
	public void setCheckBook(ChequeBook checkBook) {
		this.checkBook = checkBook;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	private Client client;
	
}
