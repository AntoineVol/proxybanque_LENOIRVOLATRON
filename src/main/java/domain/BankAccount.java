package domain;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class BankAccount implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id;
	private TypeBankAccount typeBankAccount;
	private Long numAccount;
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
	public Long getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(Long numAccount) {
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
	public TypeBankAccount getTypeBankAccount() {
		return typeBankAccount;
	}
	public void setTypeBankAccount(TypeBankAccount typeBankAccount) {
		this.typeBankAccount = typeBankAccount;
	}
	private Client client;
	
}
