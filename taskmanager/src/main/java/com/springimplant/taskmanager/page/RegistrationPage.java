package com.springimplant.taskmanager.page;

import com.springimplant.taskmanager.entity.User;
import com.springimplant.taskmanager.service.UserService;
import com.springimplant.taskmanager.utils.ApplicationContextUtils;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class RegistrationPage extends VerticalLayout implements View {
	
	private static final long serialVersionUID = -3477949619030735346L;
	public static final String NAME = "register";
	
	UserService userService;
	
	TextField name;
	TextField password;
	
	public RegistrationPage() {
		userService = ApplicationContextUtils.getApplicationContext().getBean(UserService.class);
		addHeader();
		addForm();
	}
	
	public void addHeader() {
		Label title = new Label("Register");
		title.addStyleName("h1");
		addComponent(title);	
	}
	
	public void addForm() {
		VerticalLayout form = new VerticalLayout();
		VerticalLayout text = new VerticalLayout();
		HorizontalLayout buttons = new HorizontalLayout();
		name = new TextField();
		password = new TextField();
		Button submit = new Button("Submit");
		Button login = new Button("Login");
		submit.addClickListener(e ->{
			User user = new User();
			user.setName(name.getValue());
			user.setPassword(password.getValue());
			if(userService.register(user)) {
				Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
			} else {
				Notification.show("Bad User Information",Notification.Type.ERROR_MESSAGE);
			}
		});
		login.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
		});
		text.addComponents(name,password);
		buttons.addComponents(submit,login);
		form.addComponents(text,buttons);
		addComponent(form);
	}

}
