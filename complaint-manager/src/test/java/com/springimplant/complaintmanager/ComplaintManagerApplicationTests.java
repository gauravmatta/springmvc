package com.springimplant.complaintmanager;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class ComplaintManagerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testEncryptionKey(){
//		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//		config.setPassword("springimplant");
//		config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
//		config.setKeyObtentionIterations("1000");
//		config.setPoolSize("1");
//		config.setProviderName("SunJCE");
//		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//		config.setStringOutputType("base64");
//		encryptor.setConfig(config);
//		String plaintextString = "root";
//		System.out.println("Encrypted Key: "+encryptor.encrypt(plaintextString));
	}
}
