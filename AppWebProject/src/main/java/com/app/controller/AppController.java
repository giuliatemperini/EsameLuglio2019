package com.app.controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.AppService;
import com.app.service.Element;

@RestController
public class AppController {

	/*
	 * @GetMapping("/stampa/{indice}") public String stampa(@PathVariable int
	 * indice) { String s = AppService.printElement(indice); return s; }/*
	 * 
	 * @GetMapping("/hello") public String stampa() { //String s =
	 * AppService.printElement(); return "hello"; }
	 */

	@GetMapping("/stampa/{indice}")
	public Element stampa(@PathVariable int indice) {
		return AppService.printElement(indice);
	}

	@GetMapping("/stampa")
	public Vector<Element> stampa() {
		return AppService.printElement();
	}
}
