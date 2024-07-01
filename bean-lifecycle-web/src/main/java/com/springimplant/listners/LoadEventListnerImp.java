package com.springimplant.listners;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class LoadEventListnerImp implements LoadEventListener {

	@Override
	public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
		System.out.println("onload event is called");

	}

}
