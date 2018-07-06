package domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * La classe BankAccount définie la constitution d'un compte bancaire.
 * Sa structure comporte, en plus de son identifiant de BDD, un type de compte, un numéro de compte, une date de création, un solde et un chéquier
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public abstract class BankAccount implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	/**
	 * L'id est un identifiant de base de donné généré automatiquement
	 */
	private Integer id;
	/**
	 * TypeBankAccount est le type de Compte. Il est défini lors de la création du compte
	 */
	private TypeBankAccount typeBankAccount;
	/**
	 * numAccount est le type de numéro de Compte est défini lors de la création du compte
	 */
	private Long numAccount;
	/**
	 * LocalDate est la date du jour de la création du compte. Elle est définie lors de la création du compte.
	 */
	private LocalDate creationDate;
	/**
	 * balance est le solde du compte. Sa valaur est un Long et est définie lors de la création du compte.
	 */
	private Long balance;
	/**
	 * chequeBook est le chéquier du compte. 
	 */
	private ChequeBook chequeBook;
	
	//GETTER & SETTER

	/**
	 * Getter de l'id
	 * @return id l'Id du Compte
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter de l'id du Compte
	 * @param id Id autogénéré par la BDD
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter du numéro de compte
	 * @return numAccount numéro de compte
	 */
	public Long getNumAccount() {
		return numAccount;
	}
	/**
	 * Setter du numéro de Compte
	 * @param numAccount numéro de compte
	 */
	public void setNumAccount(Long numAccount) {
		this.numAccount = numAccount;
	}
	/**
	 * Getter de la date de création du compte
	 * @return creationDate la date de création du compte
	 */
	public LocalDate getCreationDate() {
		return creationDate;
	}
	/**
	 * Setter de la date de création du compte
	 * @param creationDate la date de création du compte
	 */
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * Getter du solde du compte
	 * @return balance le solde du compte
	 */
	public Long getBalance() {
		return balance;
	}
	/**
	 * Setter du solde du Compte
	 * @param balance est le solde du compte
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	/**
	 * Getter du Client du compte
	 * @return client le Client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Setter du Client du Compte
	 * @param client un client
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * Getter du type de compte créé
	 * @return typeBankAccount le type de compte créé
	 */
	public TypeBankAccount getTypeBankAccount() {
		return typeBankAccount;
	}
	/**
	 * Setter du type de compte
	 * @param typeBankAccount le type de compte
	 */
	public void setTypeBankAccount(TypeBankAccount typeBankAccount) {
		this.typeBankAccount = typeBankAccount;
	}
	/**
	 * Carnet de Cheque du compte
	 * @return le carnet de chèque
	 */
	public ChequeBook getChequeBook() {
		return chequeBook;
	}
	/**
	 * Setter du Carnet de Chèque
	 * @param chequeBook le carnet de chèque
	 */
	public void setChequeBook(ChequeBook chequeBook) {
		this.chequeBook = chequeBook;
	}
	private Client client;
	
}
