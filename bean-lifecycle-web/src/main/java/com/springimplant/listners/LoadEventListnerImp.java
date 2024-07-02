package com.springimplant.listners;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class LoadEventListnerImp implements LoadEventListener {

	private static final long serialVersionUID = 2195020331545912105L;
	
	 public static final LoadEventListnerImp INSTANCE =
		        new LoadEventListnerImp();

	@Override
	public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
		System.out.println("onload event is called");

	}

}
