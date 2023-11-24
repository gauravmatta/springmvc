package com.springimplant.taskmanager.layout;

import com.springimplant.taskmanager.entity.User;
import com.springimplant.taskmanager.service.UserService;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class TaskItemLayout extends HorizontalLayout {
	
	public TaskItemLayout(String task,UserService service,User user) {
		addComponent(new Label(task));
		Button remove = new Button("del");
		remove.addClickListener(e -> {
			removeAllComponents();
			for(int i=0;i<user.getTasks().size();i++) {
				user.getTasks().remove(i);
				break;
			}
			service.save(user);
		});
		addComponent(remove);
	}

}
