package domain;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * La classe BankCard définie la constitution d'une carte bancaire.
 * Sa structure comporte, en plus de son identifiant de BDD, un type de carte, un numéro de carte bancaire, une date d'expiration, un compte associé
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public abstract class BankCard implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	/**
	 * L'id est un identifiant de base de donné généré automatiquement
	 */
	private Integer id;
	/**
	 * TypeBankCard est le type de Carte. Il est défini lors de la création de la carte bancaire
	 */
private String typeBankCard;

	/**
	 * numBankCard est le type de numéro de Carte est défini lors de la carte bancaire
	 */

	private Integer numBankCard;
	/**
	 * expirationDate est la date d'expiration de la carte bancaire 
	 */
	private LocalDate expirationDate;
	/**
	 * currentAccount est le compte bancaire associé à la carte bancaire
	 */
	private CurrentAccount currentAccount;
	
	//GETTER & SETTER
	/**
	 * Getter de l'id
	 * @return id l'Id de la carte bancaire
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter de l'id de la carte bancaire
	 * @param id Id autogénéré par la BDD
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter du numéro de la carte bancaire
	 * @return numBankCard le numéro de la carte bancaire
	 */
	public Integer getNumBankCard() {
		return numBankCard;
	}
	/**
	 * Setter du numéro de la carte bancaire
	 * @param numBankCard le numéro de la carte bancaire
	 */
	public void setNumBankCard(Integer numBankCard) {
		this.numBankCard = numBankCard;
	}
	/**
	 * Getter de la date d'expiration de la carte bancaire
	 * @return expirationDate la date d'expiration de la carte bancaire
	 */
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	/**
	 * Setter de la date d'expiration de la carte bancaire
	 * @param expirationDate la date d'expiration de la carte bancaire
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * Getter du type de carte bancaire
	 * @return typeBankCard le type de carte bancaire
	 */
	public TypeBankCard getTypeBankCard() {
		return TypeBankCard.valueOf(this.typeBankCard);
	}
	/**
	 * Setter du type de la carte bancaire
	 * @param typeBankCard le type de carte bancaire
	 */
	public void setTypeBankCard(TypeBankCard typeBankCard) {
		this.typeBankCard = typeBankCard.name();
	}
	/**
	 * Getter du compte courant associé
	 * @return currentAccount le compte courant associé
	 */
	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}
	/**
	 * setter du compte courant associé 
	 * @param currentAccount le compte courant associé
	 */
	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}
	

}
