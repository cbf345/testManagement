package jp.wisteria.wicket_practice;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class TestManagementSession extends WebSession{

	private static final long serialVersionUID = -7807773455295865256L;
	
	public TestManagementSession(Request request) {
		super(request);		
	}
	
	public static TestManagementSession get(){
		return (TestManagementSession)Session.get();
	}
	
	private Account account;
	
	public Account getAccount(){
		return this.account;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}

}
