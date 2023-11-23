package com.springimplant.taskmanager.page;

import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginPage extends VerticalLayout implements View {

	private static final long serialVersionUID = 6988913668805919112L;
	
	public static final String NAME = "login";
	
	public LoginPage() {
		addHeader();
		addForm();
	}
	
	public void addHeader() {
		Label title = new Label("Login");
		title.addStyleName("h1");
		addComponent(title);
	}
	
	public void addForm() {
		VerticalLayout form = new VerticalLayout();
		
		VerticalLayout text = new VerticalLayout();
		HorizontalLayout buttons= new HorizontalLayout();
		
		TextField name = new TextField();
		TextField password = new TextField();
		
		Button submit = new Button("Submit");
		Button register = new Button("Register");
		
		register.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+RegistrationPage.NAME);
		});
		text.addComponents(name,password);
		buttons.addComponents(submit,register);
		form.addComponents(text,buttons);
		addComponent(form);
	}

}
