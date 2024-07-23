package com.springimplant.connectionpooling.policy;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomSkipPolicy implements SkipPolicy {

	@Override
	public boolean shouldSkip(Throwable t, long skipCount) throws SkipLimitExceededException {
		log.info("Some Data Skipped====>");
		return t instanceof FlatFileParseException;
	}

}
