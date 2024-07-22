package com.springimplant.connectionpooling.listeners;

import org.springframework.batch.core.SkipListener;

import com.springimplant.connectionpooling.entity.Customers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomSkipListener implements SkipListener<Customers, Number> {

	@Override
	public void onSkipInRead(Throwable t) {
		log.info("A failure on Read {}",t.getMessage());
		SkipListener.super.onSkipInRead(t);
	}

	@Override
	public void onSkipInWrite(Number item, Throwable t) {
		log.info("A failure on Write {}, {}",t.getMessage(),item);
		SkipListener.super.onSkipInWrite(item, t);
	}

	@Override
	public void onSkipInProcess(Customers item, Throwable t) {
		log.info("A failure in Process by {} caused by {}",item,t.getMessage());
		SkipListener.super.onSkipInProcess(item, t);
	}
	

}
