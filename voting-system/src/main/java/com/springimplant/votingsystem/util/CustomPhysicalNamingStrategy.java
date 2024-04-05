package com.springimplant.votingsystem.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private static final long serialVersionUID = -357246552861237831L;
	public static final String TABLE_NAME_PREFIX = "springimplant_vote_";
	
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		Identifier newIdentifier = new Identifier(TABLE_NAME_PREFIX + name.getText(), name.isQuoted());
		return super.toPhysicalTableName(newIdentifier, context);
	}

}
