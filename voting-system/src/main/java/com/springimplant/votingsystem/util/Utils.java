package com.springimplant.votingsystem.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.springimplant.votingsystem.repositories.UserRepo;

@Component
public class Utils {
	
	public static String md5Java(String message)
	{
		String digest = null; 
		try 
		{ 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] hash = md.digest(message.getBytes("UTF-8")); 
			StringBuilder sb = new StringBuilder(2*hash.length); 
			for(byte b : hash)
			{ 
				sb.append(String.format("%02x", b&0xff)); 
			} 
			digest = sb.toString(); 
		} 
		catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) 
		{ 
			Logger.getLogger(UserRepo.class.getName()).log(Level.SEVERE, null, ex); 
		} 
		 
		return digest; 
	}
}
