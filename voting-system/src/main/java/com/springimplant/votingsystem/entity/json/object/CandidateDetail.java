package com.springimplant.votingsystem.entity.json.object;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDetail implements Serializable {

	private static final long serialVersionUID = -4811627460999045094L;
	
	protected String year;
	protected String assets;
	protected String liabilities;

}
