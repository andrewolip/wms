package com.wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller(value = "funcao")
public class FuncaoController {

	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "index";
	}
}
