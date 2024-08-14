package com.springimplant.contract;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorContract {
	private Integer errorCode;
	private String errorDesc;
	private Date date;
}
