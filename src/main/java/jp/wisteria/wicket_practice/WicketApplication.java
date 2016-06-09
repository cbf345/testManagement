package jp.wisteria.wicket_practice;


import org.apache.wicket.Session;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see jp.wisteria.wicket_practice.Start#main(String[])
 */
public class WicketApplication extends  WebApplication
{
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return LoginPage.class;
	}

	
	@Override
	public void init()
	{
		super.init();
	}
	
	public Session newSession(Request req,Response resp){
		return new TestManagementSession(req);
	}
}
