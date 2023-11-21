package com.springimplant.taskmanager.page;

import com.vaadin.navigator.View;
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
		HorizontalLayout form = new HorizontalLayout();
		TextField name = new TextField();
		TextField password = new TextField();
		Button submit = new Button();
		Button register = new Button();
		form.addComponents(name,password,submit,register);
		addComponent(form);
	}

}
