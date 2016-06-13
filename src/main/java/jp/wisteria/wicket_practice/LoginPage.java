package jp.wisteria.wicket_practice;



import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import jp.wisteria.wicket_practice.dao.TestManagementDAO;

public class LoginPage extends WebPage {

    private static final long serialVersionUID = 3595965707720952935L;
    
    TestManagementDAO dao = new TestManagementDAO();

    private final IModel<String> accountIdModel;
    private final IModel<String> passwordModel;

    public LoginPage() {
        accountIdModel = new Model<>();
        passwordModel = new Model<>();

        Form<Void> loginForm = new Form<Void>("loginForm") {
            private static final long serialVersionUID = 7283381648682393116L;
            @Override
            protected void onSubmit() {
            	if(dao.loginConfirm(accountIdModel.getObject(), passwordModel.getObject())){
            		TestManagementSession session = (TestManagementSession)getSession();
            		session.setAccount(dao.selectAccount(accountIdModel.getObject(), passwordModel.getObject()));
            		setResponsePage(new ProductListPage());
            	}else{
            		setResponsePage(new LoginPage());	
            	}
            }
        };
        
        add(loginForm);
        TextField<String> nameField = new TextField<>("accountId", accountIdModel);
        loginForm.add(nameField);
        TextField<String> passwordField = new TextField<>("password", passwordModel);
        loginForm.add(passwordField);
    }
}
