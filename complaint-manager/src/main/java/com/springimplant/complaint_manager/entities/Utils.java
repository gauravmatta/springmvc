package com.springimplant.complaint_manager.entities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Utils {
	
	public String md5Java(String message)
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
		catch (UnsupportedEncodingException ex) 
		{
			Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex); 
		} 
		catch (NoSuchAlgorithmException ex) 
		{ 
			Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex); 
		} 
		return digest; 
	}
}
