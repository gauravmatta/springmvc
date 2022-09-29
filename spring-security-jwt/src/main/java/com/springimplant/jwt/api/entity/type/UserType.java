package com.springimplant.jwt.api.entity.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum UserType {

	INTERNAL_GE_USER,
	EXTERNAL_GE_USER;
	
	private static final Logger LOG = LoggerFactory.getLogger(UserType.class);
	public static final UserTypeConverter CONVERTER = new UserTypeConverter();
	
	@Converter
	public static class UserTypeConverter implements AttributeConverter<UserType, String> {

		@Override
		public String convertToDatabaseColumn(UserType attribute) {
			return attribute !=null?attribute.name():null;
		}

		@Override
		public UserType convertToEntityAttribute(String dbData) {
			if(StringUtils.isEmpty(dbData)) {
				return null;
			}
			
			try {
				return UserType.valueOf(dbData.toUpperCase());
			} catch (IllegalArgumentException e) {
				LOG.error("Failed to convert value '{}' to UserType, reason: {}",dbData,e.getMessage(),e);
				return null;
			}
		}
		
	}
}
