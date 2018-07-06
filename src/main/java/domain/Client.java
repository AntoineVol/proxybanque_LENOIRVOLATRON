package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * La classe Client définie la constitution d'un client.
 * Sa structure comporte, en plus de son identifiant de BDD, un numéro de compte client, un Prénom, un Nom, une date de naissance, une liste de compte bancaire, une adresse
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public class Client implements Entity, Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * L'id est un identifiant de base de donné généré automatiquement
	 */
	private Integer id;
	/**
	 * clientAccount est le numéro de compte client du client
	 */
	private Integer clientAccount;
	/**
	 * firstName est le prénom du client
	 */
	private String firstName;
	/**
	 * lastName est le Nom du client
	 */
	private String lastName;
	/**
	 * birthday est la date de naissance du client
	 */
	private LocalDate birthday;
	/**
	 * listBankAccount est la liste des comptes du client
	 */
	private List<BankAccount> listBankAccount;
	/**
	 * address est l'adresse du client
	 */
	private Address address;
	
	//GETTER & SETTER
	/**
	 * Getter de l'id
	 * @return id l'Id du client
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter du client
	 * @param id l'Id du client
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * getter du numéro de compte du client
	 * @return un numéro de compte client
	 */
	public Integer getClientAccount() {
		return clientAccount;
	}
	/**
	 * Setter du numéro de compte client
	 * @param clientAccount le numéro de compte client
	 */
	public void setClientAccount(Integer clientAccount) {
		this.clientAccount = clientAccount;
	}
	/**
	 * getter du prénom du client
	 * @return firstName le prénom du client
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Setter du prénom du client
	 * @param firstName le prénom du client
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * getter du Nom du client
	 * @return lastName le nom du client
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Setter du nom du lient
	 * @param lastName le Nom du client
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * getter de la date d'anniversaire du client
	 * @return birthday la date d'anniversaire cu client
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * setter du la date d'anniversaire du client
	 * @param birthday la date d'anniversaire du client
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	/**
	 * la liste des compte en banque du client
	 * @return listBankAccount la liste des compte en banque du client
	 */
	public List<BankAccount> getListBankAccount() {
		return listBankAccount;
	}
	/**
	 * Setter de la liste des copmpte en banque du client
	 * @param listBankAccount la liste de compte en banque du client
	 */
	public void setListBankAccount(List<BankAccount> listBankAccount) {
		this.listBankAccount = listBankAccount;
	}
	/**
	 * getter de l'adresse du client
	 * @return address l'adresse du client
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * setter de l'adresse dui client
	 * @param address l'adresse du client
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	


}
