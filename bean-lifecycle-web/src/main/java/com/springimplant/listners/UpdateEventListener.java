package com.springimplant.listners;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

import com.springimplant.entity.Employee;

public class UpdateEventListener implements PostUpdateEventListener {

	private static final long serialVersionUID = -4578268194633559219L;
	
	public static final UpdateEventListener INSTANCE =
	        new UpdateEventListener();

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		return false;
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		if(event.getEntity() instanceof Employee) {
			Employee e = (Employee) event.getEntity();
			e.setSalary(e.getSalary()+500);
		}

	}

}
