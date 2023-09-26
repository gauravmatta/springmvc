package com.springimplant.jwt.api.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomDBNamingUtil extends PhysicalNamingStrategyStandardImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TABLE_NAME_PREFIX_STRING = "javaimplant_";
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		
		Identifier newIdentifier = new Identifier(TABLE_NAME_PREFIX_STRING + name.getText(), name.isQuoted());
		return super.toPhysicalTableName(newIdentifier, context);
	}
	
	
	
	
	

}
