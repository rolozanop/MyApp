package com.myapp.bean;

import java.util.ArrayList;
import java.util.List;


public class SimilarProducts {

	private List<ProductDetail> similarProductsList;

	public List<ProductDetail> getSimilarProductsList() {
		return similarProductsList;
	}

	public void setSimilarProductsList(List<ProductDetail> similarProductsList) {
		this.similarProductsList = similarProductsList;
	}

	public SimilarProducts(List<ProductDetail> similarProductsList) {
		super();
		this.similarProductsList = similarProductsList;
	}

	public SimilarProducts() {
		super();
		this.similarProductsList=new ArrayList<>();
	}
	
}
