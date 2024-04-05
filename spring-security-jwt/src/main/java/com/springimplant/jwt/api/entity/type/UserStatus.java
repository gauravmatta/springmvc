package com.springimplant.jwt.api.entity.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.swing.text.AbstractDocument.AttributeContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public enum UserStatus {

	ACTIVE,
	INACTIVE,
	PENDING_ONBOARD;
	
	private static final Logger LOG = LoggerFactory.getLogger(UserStatus.class);
	
	public static final UserStatusConverter CONVERTER = new UserStatusConverter();
	
	@Converter
	public static class UserStatusConverter implements AttributeConverter<UserStatus, String> {

		@Override
		public String convertToDatabaseColumn(UserStatus attribute) {
			return attribute != null?attribute.name():null;
		}

		@Override
		public UserStatus convertToEntityAttribute(String dbData) {
			if(StringUtils.isEmpty(dbData)) {
				return null;
			}
			try {
				return UserStatus.valueOf(dbData.toUpperCase());
			} catch (IllegalArgumentException e) {
				LOG.error("Failed to convert value '{}' to UserStatus, reason: {}",dbData,e.getMessage(),e);
				return null;
			}
		}
		
	}
}
