package domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * La classe ChequeBook définie la constitution d'un carnet de chèque.
 * Sa structure comporte, en plus de son identifiant de BDD, une date d'envoi, une date de récéption, un compte en banque associé
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public class ChequeBook implements Entity, Serializable{


	private static final long serialVersionUID = 1L;
	/**
	 * L'id est un identifiant de base de donné généré automatiquement
	 */
	private Integer id;
	/**
	 * sendDate est la date d'envoie du carnet de chèque. il est généré lors de la création du carnet.
	 */
	private LocalDate sendDate;
	/**
	 * receptionDate est la date de récéption du carnet de chèque. Il est définit d'après la date d'envoie + 7 jours
	 */
	private LocalDate receptionDate;
	/**
	 * bankAccount est le compte en banque associé au chèque
	 */
	private BankAccount bankAccount;
	
	
	//GETTER & SETTER
	/**
	 * Getter de l'id
	 * @return id l'Id du carnet de chèque
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter du carnet de chèque*
	 * @param id l'Id du chèque
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter de la date d'envoie du carnet de chèque
	 * @return sendDate la date d'envoie du carnet de chèque
	 */
	public LocalDate getSendDate() {
		return sendDate;
	}
	/**
	 * Setter de la date d'envoi du carnet de chèque
	 * @param sendDate la date d'envoie du carnet de chèque
	 */
	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}
	/**
	 * Getter de la date de réception du carnet de chèque
	 * @return receptionDate la date de réception du carnet
	 */
	public LocalDate getReceptionDate() {
		return receptionDate;
	}
	/**
	 * Setter de la date de réception du carnet de chèque
	 * @param receptionDate la date de réception du carnet de chèque
	 */
	public void setReceptionDate(LocalDate receptionDate) {
		this.receptionDate = receptionDate;
	}
	/**
	 * Getter du compte bancaire associé
	 * @return bankAccount le compte en banque associé au chèque
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	/**
	 * Setter du compte bancaire associé au chéquier
	 * @param bankAccount le compte en banque associé au chéquier
	 */
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}


	

}
