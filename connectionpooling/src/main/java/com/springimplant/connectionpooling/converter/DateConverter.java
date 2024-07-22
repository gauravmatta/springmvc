package com.springimplant.connectionpooling.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate,String> {

	@Override
	public String convertToDatabaseColumn(LocalDate attribute) {
		return attribute.toString();
	}

	@Override
	public LocalDate convertToEntityAttribute(String dbData) {
		return LocalDate.parse(dbData, DateTimeFormatter.ISO_DATE_TIME);
	}

}
