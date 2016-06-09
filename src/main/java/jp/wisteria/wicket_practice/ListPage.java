package jp.wisteria.wicket_practice;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class ListPage extends WebPage{
	
	private static final long serialVersionUID = 728995498131999146L;
	
	public ListPage(){
		TestManagementSession session = (TestManagementSession)getSession();
		Account account = session.getAccount();
		add(new Label("accountName",account.getAccountId()));
	}
}
