package domain;

import java.io.Serializable;

/**
 * La classe CurrentAccount définie la constitution d'un compte courant.
 * Sa structure comporte, une carte bancaire associée (Visa electron ou Premier)
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public class CurrentAccount extends BankAccount implements Entity, Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * bankCard est la carte bancaire associé à un client
	 */
	private BankCard bankCard;
	
	//GETTER & SETTER
	/**
	 * getter d'une carte bancaire 
	 * @return bankCard une carte bancaire
	 */
	public BankCard getBankCard() {
		return bankCard;
	}
	/**
	 * setter d'une carte bancaire
	 * @param bankCard une carte bancaire
	 */
	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}
}
