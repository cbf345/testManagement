package jp.wisteria.wicket_practice;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class TestManagementSession extends WebSession{

	private static final long serialVersionUID = -7807773455295865256L;
	
	public TestManagementSession(Request request) {
		super(request);
	}

	public Account account = null;
	
	public Account getAccount(){
		return this.account;
	}
	
	public void setAccount(Account account){
		this.account=account;
	}

}
