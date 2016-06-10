package jp.wisteria.wicket_practice.bean;

public class Account {
	private String accountName;
	private String accountId;
	private String department;
	
	public Account(String accountName,String accountId,String department){
		this.accountName = accountName;
		this.accountId = accountId;
		this.department = department;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getDepartment() {
		return department;
	}

	
}
