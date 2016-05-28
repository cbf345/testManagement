package jp.wisteria.wicket_practice;

import org.apache.wicket.Request;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.authorization.strategies.role.Roles;

public class AccountSession extends AuthenticatedWebSession{

	private static final long serialVersionUID = 8577478285818158892L;

	public AccountSession(Request request) {
		super(request);
	}
	
	@Override
	public boolean authenticate(String accountId, String password) {
		return new TestManagementDAO().loginConfirm(accountId, password);
	}

	@Override
	public Roles getRoles() {
		if(isSignedIn()){
			return new Roles(Roles.ADMIN);
		}
		return null;
	}

}
