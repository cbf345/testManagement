package jp.wisteria.wicket_practice;

import org.apache.wicket.markup.html.form.Button;

public class LogoutConfirmPage extends NavBar{

	private static final long serialVersionUID = 2418938716702009234L;

	public LogoutConfirmPage(){
		Button logoutYBtn = new Button("logoutYBtn"){
			private static final long serialVersionUID = 248338934938725629L;

			public void onSubmit(){
				getSession().invalidate();
				setResponsePage(new LogoutConfirmPage());
			}
		};
		
		Button logoutNBtn = new Button("logoutNBtn"){
			private static final long serialVersionUID = -4742746237653251761L;

			public void onSubmit(){
				setResponsePage(new ProductListPage());
			}
		};
		
		add(logoutYBtn);
		add(logoutNBtn);
	}

}
