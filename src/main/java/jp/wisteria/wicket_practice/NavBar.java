package jp.wisteria.wicket_practice;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import jp.wisteria.wicket_practice.bean.Account;

public class NavBar extends WebPage{

	private static final long serialVersionUID = 741849353040974321L;
	
	public NavBar(){
		TestManagementSession session = (TestManagementSession)getSession();
		Account account = session.getAccount();
		add(new Label("accountName",account.getAccountId()));
		
		Link createAccountLink = new Link("createAccountLink"){
			private static final long serialVersionUID = 6033791522539506226L;

			public void onClick(){
				setResponsePage(new CreateAccountPage());
			}
		};
		
		Link productListLink = new Link("productListLink"){
			private static final long serialVersionUID = -7897368762346521153L;

			public void onClick(){
				setResponsePage(new ProductListPage());
			}
		};
		
		Link logoutLink = new Link("logoutLink"){
			private static final long serialVersionUID = -7897368762346521153L;

			public void onClick(){
				setResponsePage(new LogoutConfirmPage());
			}
		};
		add(createAccountLink);
		add(productListLink);
		add(logoutLink);
	}
}
