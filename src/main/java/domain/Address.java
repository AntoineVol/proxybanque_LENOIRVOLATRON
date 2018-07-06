package domain;

import java.io.Serializable;

/**
 * La classe Adress d�finie la constitution d'une adresse de client.
 * Sa structure comporte, en plus de son identifiant de BDD, deux ligne d'adresse, un code postal pouvant �tre en alpha-nuum�rique, une ville et un pays
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public class Address implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	/**
	 * L'id est un identifiant de base de donn�e g�n�r� automatiquement
	 */
	private Integer id;
	/**
	 * L'addressLine1 est un champs libre de renseignement d'adresse. Il est conseill� de le remplir avec le n� de voie et la voie de l'adresse.
	 */
	private String addressLine1;
	/**
	 * L'addressLine1 est un champs libre de renseignement d'adresse. Il est conseill� de le remplir avec des indications supplementaire de l'adresse comme l'�tage, la situation de porte sur le palier ...
	 */
	private String addressLine2;
	
	/**
	 * Le postalCode contient le code postal. Celui-ci peut �tre de type Alpha-numerique pour permettre son utilisation � l'international
	 */
	private String postalCode;
	/**
	 * Le city contient la ville de l'adresse
	 */
	private String city;
	/**
	 * Le country contient le pays de l'adresse
	 */
	private String country;
	
	private Client client;
	
	
	//GETTER & SETTER
	/**
	 * Getter de l'id
	 * @return L'id "BBD" de l'adresse
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter de l'id
	 * @param id Id autog�n�r� par la BDD
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter de la premi�re ligne l'adresse
	 * @return La premi�re ligne de l'addresse
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * Setter de la premi�re ligne de l'adresse
	 * @param addressLine1 Premi�re ligne de l'adresse
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * Getter de la seconde ligne l'adresse
	 * @return La seconde ligne de l'adresse
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * Setter de la seconde ligne de l'adresse
	 * @param addressLine2 Seconde ligne de l'adresse
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * Getter du code postal de l'adresse
	 * @return postalCode Le code postal de l'adresse
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * Setter du code postal de l'adresse
	 * @param postalCode Code postale de l'adresse
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * Getter de ville de l'adresse
	 * @return La ville de l'addresse
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Setter de la ville de l'adresse
	 * @param city Ville de l'adresse
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Getter du pays de l'adresse
	 * @return Le pays de l'addresse
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Setter du pays de l'adresse
	 * @param country Pays de l'adresse
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * Getter du client
	 * @return un Client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Setter d'nu Client
	 * @param un Client
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}
