package com.example.marvelheroapi.services;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MarvelService {
	
	private String host;
	private String apiKey;
	private String pApiKey;
	
	public MarvelService() {
		this.host = "https://gateway.marvel.com:443/v1/public";
		this.apiKey = "147df835c446c82b4d5c48297ab63786";
		this.pApiKey = "c045905554a57a74a0403238cdf270aa7731732f";
	}
	
	private String generateHash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		String strng = "1" + pApiKey + apiKey;
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] result = md.digest(strng.getBytes());
		BigInteger number = new BigInteger(1, result);
		String hashText = number.toString(16);
		    
		return hashText;
		
	}
	
	
	public Object getComics() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		String hash = generateHash();
		ObjectMapper mapper = new ObjectMapper();
		
		final String url = host + "/comics?ts=1&apikey=" + apiKey + "&hash=" + hash;
		RestTemplate restTemplate = new RestTemplate();	
		ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		String body = result.getBody();
		Gson gson = new GsonBuilder().create();
		Object frest = Arrays.asList(gson.fromJson(body, Object.class));
		System.out.print(frest);
	

		return frest;
		
	}

}
