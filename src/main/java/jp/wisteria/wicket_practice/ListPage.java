package jp.wisteria.wicket_practice;

import org.apache.wicket.markup.html.basic.Label;

public class ListPage extends NavBar{
	
	private static final long serialVersionUID = 728995498131999146L;
	
	public ListPage(){
		super();
		add(new Label("yattaze","やったぜ"));
	}
}
