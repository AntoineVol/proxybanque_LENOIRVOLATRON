package domain;

import java.io.Serializable;

/**
 * La classe Adress d�finie la constitution d'une adresse de client.
 * Sa structure comporte, en plus de son identifiant de BDD, deux ligne d'adresse, un code postal pouvant �tre en alpha-nuum�rique, une ville et un pays
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public class Address implements Entity, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * L'id est un identifiant de base de donn�e g�n�r� automatiquement
	 */
	private Integer id;
	/**
	 * 
	 */
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
	private String city;
	private String country;
	
	
	//GETTER & SETTER
	/**
	 *
	 * @return L'id "BBD" de l'adresse
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
