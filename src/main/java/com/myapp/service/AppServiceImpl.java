package com.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myapp.bean.ProductDetail;
import com.myapp.bean.SimilarProducts;


@Service
public class AppServiceImpl implements AppService {

	@Value("${url}")
	private String url;

	@Override
	public SimilarProducts getSimilarProducts(Integer productId) {
				
		RestTemplate restTemplate= new RestTemplate();				
		SimilarProducts similarProducts= new SimilarProducts();	
		
		try {
			List<Integer> ids = restTemplate.getForObject(url+productId.toString()+"/similarids", ArrayList.class);
			
			if(ids!=null) {
				ids.forEach(x->similarProducts.getSimilarProductsList().add(restTemplate.getForObject(url+x, ProductDetail.class)));
			}
		}catch(Exception e) {
			new SimilarProducts(); 
		}
			
		return similarProducts;
	}	
}
