package com.springimplant.taskmanager.page;

import com.springimplant.taskmanager.entity.User;
import com.springimplant.taskmanager.service.UserService;
import com.springimplant.taskmanager.utils.ApplicationContextUtils;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginPage extends VerticalLayout implements View {

	private static final long serialVersionUID = 6988913668805919112L;
	
	public static final String NAME = "login";
	
	UserService userService;
	TextField name;
	TextField password;
	
	public LoginPage() {
		userService = ApplicationContextUtils.getApplicationContext().getBean(UserService.class);
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
		
		name = new TextField();
		password = new TextField();
		
		Button submit = new Button("Submit");
		Button register = new Button("Register");
		submit.addClickListener(e ->{
			User user = new User();
			user.setName(name.getValue());
			user.setPassword(password.getValue());
			User currentUser = userService.getUser(user.getName());
			if(validate(user,currentUser)) {
				VaadinSession.getCurrent().setAttribute("user",currentUser);
				getUI().getNavigator().addView(HomePage.NAME, HomePage.class);
				Page.getCurrent().setUriFragment("!"+HomePage.NAME);
			} else {
				Notification.show("Invalid User Credentials",Notification.Type.ERROR_MESSAGE);
			}
		});
		
		register.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+RegistrationPage.NAME);
		});
		text.addComponents(name,password);
		buttons.addComponents(submit,register);
		form.addComponents(text,buttons);
		addComponent(form);
	}
	
	private boolean validate(User user,User currentUser) {
		if(currentUser == null || !currentUser.getPassword().equals(user.getPassword())) {
			return false;
		}
		return true;
	}
}
