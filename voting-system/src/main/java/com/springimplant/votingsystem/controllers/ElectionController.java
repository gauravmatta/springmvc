package com.springimplant.votingsystem.controllers;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/election")
public class ElectionController {

	public final Logger logger=Logger.getLogger(ElectionController.class);
}