package com.myapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.bean.SimilarProducts;
import com.myapp.service.AppService;

@RestController
public class Controller {
		
	@Autowired
	private AppService appService;

	@GetMapping("/product/{productId}/similar")
	public ResponseEntity<?> get(
			@RequestBody(required = true) @PathVariable(value = "productId") Integer productId) {
				
		SimilarProducts result = appService.getSimilarProducts(productId);
		
		if (result!=null && !result.getSimilarProductsList().isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
