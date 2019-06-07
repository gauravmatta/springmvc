package com.springimplant.mvc.controllers;

import java.math.BigDecimal;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springimplant.mvc.model.Account;

@Controller
@RequestMapping("/v1/forecasting")
@ResponseBody
public class AccountController {

	@RequestMapping(value="accounts",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public Account[] getAccounts()
	{
		Account[] accounts=new Account[] {
				new Account("G435","Gaurav",BigDecimal.valueOf(2300.60)),
				new Account("G789","Mohit",BigDecimal.valueOf(4500.60))
		};
		return accounts;
	}
}
