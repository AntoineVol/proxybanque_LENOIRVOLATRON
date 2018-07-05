package domain;

import java.time.LocalDate;
import java.util.List;

public class Client {
	
	private Integer id;
	private Integer clientAccount;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private List<BankAccount> listBankAccount;
	private Address adressPrincipal;
	
	//GETTER & SETTER
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClientAccount() {
		return clientAccount;
	}
	public void setClientAccount(Integer clientAccount) {
		this.clientAccount = clientAccount;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public List<BankAccount> getListBankAccount() {
		return listBankAccount;
	}
	public void setListBankAccount(List<BankAccount> listBankAccount) {
		this.listBankAccount = listBankAccount;
	}
	public Address getAdressPrincipal() {
		return adressPrincipal;
	}
	public void setAdressPrincipal(Address adressPrincipal) {
		this.adressPrincipal = adressPrincipal;
	}
	public Address getAdressSecondary() {
		return adressSecondary;
	}
	public void setAdressSecondary(Address adressSecondary) {
		this.adressSecondary = adressSecondary;
	}
	private Address adressSecondary;

}
