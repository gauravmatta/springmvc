package com.springimplant.votingsystem.entity.converter;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springimplant.votingsystem.controllers.LoginController;
import com.springimplant.votingsystem.entity.json.object.CandidateDetail;

@Converter(autoApply = true)
public class CandidateDetailConverter implements AttributeConverter<Collection<CandidateDetail>, String> {
	
	public final static Gson GSON = new Gson();
	public final Logger logger=Logger.getLogger(CandidateDetailConverter.class);

	@Override
	public String convertToDatabaseColumn(Collection<CandidateDetail> attribute) {
		logger.info("Converting Candidate Detail to Column");
		return GSON.toJsonTree(attribute).toString();
	}

	@Override
	public Collection<CandidateDetail> convertToEntityAttribute(String dbData) {
		Type collectionType = new TypeToken<Collection<CandidateDetail>>(){}.getType();
		return GSON.fromJson(dbData, collectionType);
	}

}
